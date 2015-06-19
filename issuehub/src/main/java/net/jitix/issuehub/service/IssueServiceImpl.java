package net.jitix.issuehub.service;

import java.util.ArrayList;
import java.util.List;
import net.jitix.issuehub.entity.Comment;
import net.jitix.issuehub.entity.Issue;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.util.ObjectMappingUtil;
import net.jitix.issuehub.vo.CommentDetails;
import net.jitix.issuehub.vo.IssueInfo;
import net.jitix.issuehub.vo.NewIssueDetails;
import net.jitix.issuehub.vo.SaveIssueDetails;
import net.jitix.issuehub.vo.UserDetails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private MongoDBConnectionService connService;
    
    @Autowired
    private IssueTypeService issueTypeService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMappingUtil mappingUtil;

    @Override
    public synchronized Integer getNewIssueNumber() {

        Query query = new Query();
        query.limit(1);
        query.with(new Sort(Sort.Direction.DESC, "_id"));

        Issue latest = this.connService.getMongoOperations().findOne(query, Issue.class);
        if (latest == null) {
            return 1000;
        } else {
            return latest.getIssueNumber() + 1;
        }
    }

    @Override
    public Integer createNewIssue(UserDetails reporterDetails, NewIssueDetails issueDetails) throws AppException {
        long timestamp = System.currentTimeMillis();

        if(StringUtils.isBlank(issueDetails.getTitle())){
            throw new AppException("Please set a title");
        }
        
        if(StringUtils.isBlank(issueDetails.getDescription())){
            throw new AppException("Please set a description");
        }
        
        if(StringUtils.isBlank(issueDetails.getIssueTypeName())){
            throw new AppException("Please select an issue type");
        }
        
        if(StringUtils.isBlank(issueDetails.getPriority())){
            throw new AppException("Please select a priority");
        }
        
        if(StringUtils.isBlank(issueDetails.getAssigneeUserId())){
            throw new AppException("Please select an assignee");
        }
        
        IssueType issueType = this.issueTypeService.getIssueTypeByName(issueDetails.getIssueTypeName());
        if(issueType==null){
            throw new AppException("Invalid issue type");
        }
        else{
            System.out.println(issueType);
        }

        Issue issue = this.mappingUtil.map(issueDetails, Issue.class);

        issue.setIssueNumber(this.getNewIssueNumber());
        issue.setReporterUserId(reporterDetails.getUserId());
        issue.setReportedTimestamp(timestamp);
        issue.setUpdatedByUserId(reporterDetails.getUserId());
        issue.setUpdatedTimestamp(timestamp);
        issue.setStatus(issueType.getStatusList().get(0).getStatus());
        if(!CollectionUtils.isEmpty(issueType.getStatusList().get(0).getSubstatusList())){
            issue.setSubstatus(issueType.getStatusList().get(0).getSubstatusList().get(0));
        }
        issue.setComments(new ArrayList<>(0));

        this.connService.getMongoOperations().save(issue);

        return issue.getIssueNumber();
    }

    @Override
    public Issue getIssue(Integer issueNumber) throws AppException {
        return this.connService.getMongoOperations().findById(issueNumber, Issue.class);
    }

    @Override
    public List<IssueInfo> listIssues() throws AppException {
        List<IssueInfo> issueInfoList= this.mappingUtil.mapList(
                this.connService.getMongoOperations().findAll(Issue.class),
                IssueInfo.class);
        
        for(IssueInfo issueInfo:issueInfoList){
            issueInfo.setReporterUserName(this.userService.getUser(issueInfo.getReporterUserId()).getUserName());
            issueInfo.setAssigneeUserName(this.userService.getUser(issueInfo.getAssigneeUserId()).getUserName());
            issueInfo.setUpdatedByUserName(this.userService.getUser(issueInfo.getUpdatedByUserId()).getUserName());
        }
        
        return issueInfoList;
    }

    @Override
    public void updateIssue(Integer issueNumber, UserDetails updaterDetails, SaveIssueDetails issueDetails, CommentDetails commentDetails) throws AppException {

        long timestamp=System.currentTimeMillis();
        
        if (issueDetails != null) {
            this.connService.getMongoOperations().updateFirst(
                    new Query().addCriteria(Criteria.where("_id").is(issueNumber)),
                    new Update()
                    .set("title", issueDetails.getTitle())
                    .set("description", issueDetails.getDescription())
                    .set("assigneeUserId", issueDetails.getAssigneeUserId())
                    .set("status", issueDetails.getStatus())
                    .set("substatus", issueDetails.getSubstatus())
                    .set("updatedByUserId",updaterDetails.getUserId())
                    .set("updatedTimestamp", timestamp),
                    Issue.class);
        }

        if (commentDetails != null) {
            Comment comment = this.mappingUtil.map(commentDetails, Comment.class);
            comment.setUserId(updaterDetails.getUserId());
            comment.setTimestamp(timestamp);

            this.connService.getMongoOperations().updateFirst(
                    new Query().addCriteria(Criteria.where("_id").is(issueNumber)),
                    new Update().push("comments", comment),
                    Issue.class);
        }

    }

    @Override
    public void deleteIssue(Integer issueNumber) throws AppException {
        this.connService.getMongoOperations().remove(
                new Query().addCriteria(Criteria.where("_id").is(issueNumber)), 
                Issue.class);
    }

}

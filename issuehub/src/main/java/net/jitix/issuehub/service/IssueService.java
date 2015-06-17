package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.entity.Issue;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.vo.CommentDetails;
import net.jitix.issuehub.vo.IssueInfo;
import net.jitix.issuehub.vo.NewIssueDetails;
import net.jitix.issuehub.vo.SaveIssueDetails;
import net.jitix.issuehub.vo.UserDetails;

public interface IssueService {
    
    public Integer getNewIssueNumber();
    
    public Integer createNewIssue(UserDetails reporterDetails, NewIssueDetails issueDetails) throws AppException;
    
    public Issue getIssue(Integer issueNumber) throws AppException;
    
    public List<IssueInfo> listIssues() throws AppException;
    
    public void updateIssue(Integer issueNumber, 
            UserDetails updaterDetails, SaveIssueDetails issueDetails, CommentDetails commentDetails)
            throws AppException;
    
    public void deleteIssue(Integer issueNumber) throws AppException;
    
}

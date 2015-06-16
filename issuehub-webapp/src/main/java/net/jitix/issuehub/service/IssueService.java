package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.vo.CommentDetails;
import net.jitix.issuehub.vo.IssueDetails;
import net.jitix.issuehub.vo.IssueInfo;
import net.jitix.issuehub.vo.NewIssueDetails;
import net.jitix.issuehub.vo.SaveIssueDetails;

public interface IssueService {
    
    public Integer getNewIssueNumber();
    
    public Integer createNewIssue(NewIssueDetails issueDetails) throws AppException;
    
    public IssueDetails getIssue(Integer issueNumber) throws AppException;
    
    public List<IssueInfo> listIssues() throws AppException;
    
    public void updateIssue(Integer issueNumber, 
            SaveIssueDetails issueDetails, List<CommentDetails> comments)
            throws AppException;
    
    public void deleteIssue(Integer issueNumber) throws AppException;
    
}

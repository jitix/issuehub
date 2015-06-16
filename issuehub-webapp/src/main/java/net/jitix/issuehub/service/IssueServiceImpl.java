package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.vo.CommentDetails;
import net.jitix.issuehub.vo.IssueDetails;
import net.jitix.issuehub.vo.IssueInfo;
import net.jitix.issuehub.vo.NewIssueDetails;
import net.jitix.issuehub.vo.SaveIssueDetails;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl extends AbstractMongoDBService implements IssueService{

    @Override
    public Integer getNewIssueNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer createNewIssue(NewIssueDetails issueDetails) throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IssueDetails getIssue(Integer issueNumber) throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IssueInfo> listIssues() throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateIssue(Integer issueNumber, SaveIssueDetails issueDetails, List<CommentDetails> comments) throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteIssue(Integer issueNumber) throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

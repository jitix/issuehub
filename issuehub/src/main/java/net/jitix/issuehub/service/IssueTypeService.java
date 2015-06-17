package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.exception.AppException;

public interface IssueTypeService {

    public IssueType getIssueType(String issueTypeId) throws AppException;
    
    public List<IssueType> getIssueTypes() throws AppException;
    
}

package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class IssueTypeServiceImpl implements IssueTypeService {

    @Autowired
    private MongoDBConnectionService connService;

    @Override
    public IssueType getIssueType(String issueTypeId) throws AppException {
        IssueType issueType = this.connService.getMongoOperations().findById(issueTypeId, IssueType.class);

        if (issueType == null) {
            throw new AppException("Invalid issue type");
        }

        return issueType;
    }

    @Override
    public IssueType getIssueTypeByName(String issueTypeName) throws AppException {
        return this.connService.getMongoOperations().findOne(
                new Query().addCriteria(Criteria.where("issueTypeName").is(issueTypeName)), 
                IssueType.class);
    }

    @Override
    public List<IssueType> getIssueTypes() throws AppException {
        return this.connService.getMongoOperations().findAll(IssueType.class);
    }

}

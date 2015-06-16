package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.exception.AppException;
import org.springframework.stereotype.Service;

@Service
public class IssueTypeServiceImpl extends AbstractMongoDBService implements IssueTypeService {

    @Override
    public List<IssueType> getIssueTypes() throws AppException {
        return this.getMongoOperations().findAll(IssueType.class);
    }

}

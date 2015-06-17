package net.jitix.issuehub.util;

import java.util.Arrays;
import net.jitix.issuehub.entity.Issue;
import net.jitix.issuehub.entity.IssueType;
import net.jitix.issuehub.entity.Status;
import net.jitix.issuehub.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;

public class DBBootstrapUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DBBootstrapUtil.class);

    public static void bootstrapDB(MongoOperations mongoOperations) {
        LOG.info("Bootstrapping database");

        if (!mongoOperations.collectionExists(User.class)) {
            LOG.info("Users collection does not exist. Creating collection.");

            //create users collection
            mongoOperations.createCollection(User.class);

            LOG.info("Creating admin user.");
            //create admin user
            User adminUser = new User(null, "Admin", "admin@localhost", DigestUtils.sha256Hex("admin"), Boolean.TRUE);
            mongoOperations.save(adminUser);
        }

        if (!mongoOperations.collectionExists(Issue.class)) {
            LOG.info("Issues collection does not exist. Creating collection.");

            //create issues collection
            mongoOperations.createCollection(Issue.class);

        }

        if (!mongoOperations.collectionExists(IssueType.class)) {
            LOG.info("Issue Types collection does not exist. Creating collection.");

            //create issue types
            mongoOperations.createCollection(IssueType.class);

            //create issue types
            LOG.info("Creating issue type 'Bug'");
            
            //#1 Bug
            IssueType bug = new IssueType(null, "Bug",
                    Arrays.asList(
                            new Status("Open", Arrays.asList()),
                            new Status("Reopened", Arrays.asList()),
                            new Status("In Progress", Arrays.asList()),
                            new Status("Resolved", Arrays.asList("Fixed", "Not a Bug", "Won't Fix", "Cannot Reproduce")),
                            new Status("Closed", Arrays.asList("Verified", "Invalid"))
                    )
            );

            LOG.info("Creating issue type 'Story'");
            //#2 Story
            IssueType story = new IssueType(null, "Story",
                    Arrays.asList(
                            new Status("New", Arrays.asList()),
                            new Status("Defined", Arrays.asList()),
                            new Status("In Progress", Arrays.asList("Development", "Unit Test")),
                            new Status("Code Review", Arrays.asList()),
                            new Status("Peer Test", Arrays.asList()),
                            new Status("Resolved", Arrays.asList()),
                            new Status("Testing", Arrays.asList("In Progress", "Completed")),
                            new Status("Closed", Arrays.asList())
                    )
            );

            mongoOperations.save(bug);
            mongoOperations.save(story);
        }
    }

}

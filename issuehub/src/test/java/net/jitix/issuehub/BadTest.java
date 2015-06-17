package net.jitix.issuehub;

import java.util.List;
import net.jitix.issuehub.config.MongoConfig;
import net.jitix.issuehub.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class BadTest {

    public static void main(String[] args) {
 
	// For XML
	//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
 
	// For Annotation
	ApplicationContext ctx = 
             new AnnotationConfigApplicationContext(MongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
 
	User user = new User(null, "name 2", "name1@corp.com", "asas", Boolean.TRUE);
 
	// save
	mongoOperation.save(user);
 
	// now user object got the created id.
	System.out.println("1. user : " + user);
 
	// query to search user
	Query searchUserQuery = new Query(Criteria.where("userName").is("name 1"));
 
	// find the saved user again.
	User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	System.out.println("2. find - savedUser : " + savedUser);
 
	// update password
//	mongoOperation.updateFirst(searchUserQuery, 
//                         Update.update("password", "new password"),User.class);
 
	// find the updated user object
	//User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
 
	//System.out.println("3. updatedUser : " + updatedUser);
 
	// delete
	//mongoOperation.remove(searchUserQuery, User.class);
 
	// List, it should be empty now.
	List<User> listUser = mongoOperation.findAll(User.class);
	System.out.println("4. Number of user = " + listUser.size());
 
    }
    
}

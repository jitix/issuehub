package net.jitix.issuehub.service;

import java.util.List;
import javax.annotation.PostConstruct;
import net.jitix.issuehub.config.MongoConfig;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOG=LoggerFactory.getLogger(UserServiceImpl.class);
    
    private MongoOperations mongoOperations;
    
    @PostConstruct
    public void initialize(){
        ApplicationContext ctx = 
             new AnnotationConfigApplicationContext(MongoConfig.class);
	this.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
    }
    
    @Override
    public boolean authenticateUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUser(UserSaveDetails userSaveDetails) {
        
    }

    @Override
    public UserDetails getUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserDetails> listUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetails getUserByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

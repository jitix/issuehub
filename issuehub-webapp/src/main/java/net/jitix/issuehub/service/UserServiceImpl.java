package net.jitix.issuehub.service;

import java.util.List;
import javax.annotation.PostConstruct;
import net.jitix.issuehub.config.MongoConfig;
import net.jitix.issuehub.entity.User;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.util.ObjectMappingUtil;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ObjectMappingUtil mappingUtil;

    private MongoOperations mongoOperations;

    @PostConstruct
    public void initialize() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MongoConfig.class);
        this.mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public boolean authenticateUser(String email, String password) throws AppException {
        User user = this.mongoOperations.findOne(
                new Query(Criteria.where("email").is(email)), User.class);
        String passwordHash = DigestUtils.sha256Hex(password);

        return user.getPasswordHash().equals(passwordHash);
    }

    @Override
    public void saveUser(String userId, UserSaveDetails userSaveDetails) throws AppException {
        User user = this.mappingUtil.map(userSaveDetails, User.class);
        user.setUserId(userId);
        user.setPasswordHash(DigestUtils.sha256Hex(userSaveDetails.getPassword()));
        
        
        //check if email already exists
        UserDetails existingUser=this.getUserByEmail(userSaveDetails.getEmail());
        if(existingUser!=null){
            //if its its new user details or email is registered with existing different user
            if(StringUtils.isEmpty(userId) || !existingUser.getUserId().equals(userId)){
                throw new AppException("Email address is already in use by different user");
            }
        }

        this.mongoOperations.save(user);
    }

    @Override
    public UserDetails getUser(String userId) throws AppException {
        User user = this.mongoOperations.findById(userId, User.class);

        return this.mappingUtil.map(user, UserDetails.class);
    }

    @Override
    public List<UserDetails> listUsers() throws AppException {
        List<User> users = this.mongoOperations.findAll(User.class);

        return this.mappingUtil.mapList(users, UserDetails.class);
    }

    @Override
    public void deleteUser(String userId) throws AppException {
        this.mongoOperations.remove(userId);
    }

    @Override
    public UserDetails getUserByEmail(String email) throws AppException {
        User user = this.mongoOperations.findOne(
                new Query(Criteria.where("email").is(email)), User.class);

        return this.mappingUtil.map(user, UserDetails.class);
    }

}

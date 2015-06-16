package net.jitix.issuehub.service;

import java.util.List;
import javax.annotation.PostConstruct;
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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractMongoDBService implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ObjectMappingUtil mappingUtil;

    @PostConstruct
    public void createDefaultUser() {

    }

    @Override
    public boolean authenticateUser(String email, String password) throws AppException {
        User user = this.getMongoOperations().findOne(
                new Query(Criteria.where("email").is(email)), User.class);
        String passwordHash = DigestUtils.sha256Hex(password);

        if (user == null) {
            throw new AppException("User does not exist");
        }

        return user.getPasswordHash().equals(passwordHash);
    }

    @Override
    public void saveUser(String userId, UserSaveDetails userSaveDetails) throws AppException {
        boolean isUpdate = (userId != null);

        User user = this.mappingUtil.map(userSaveDetails, User.class);

        if (StringUtils.isNotBlank(userSaveDetails.getPassword())) {
            user.setPasswordHash(DigestUtils.sha256Hex(userSaveDetails.getPassword()));
        }

        if (isUpdate) {
            user.setUserId(userId);
        } else {
            //check if email already exists in case of new use creation
            UserDetails existingUser = this.getUserByEmail(userSaveDetails.getEmail());
            if (existingUser != null) {
                //if its its new user details or email is registered with existing different user
                if (StringUtils.isEmpty(userId) || !existingUser.getUserId().equals(userId)) {
                    throw new AppException("Email address is already in use by different user");
                }
            }
        }

        this.getMongoOperations().save(user);
    }

    @Override
    public UserDetails getUser(String userId) throws AppException {
        User user = this.getMongoOperations().findById(userId, User.class);

        return this.mappingUtil.map(user, UserDetails.class);
    }

    @Override
    public List<UserDetails> listUsers() throws AppException {
        List<User> users = this.getMongoOperations().findAll(User.class);

        return this.mappingUtil.mapList(users, UserDetails.class);
    }

    @Override
    public void deleteUser(String userId) throws AppException {
        this.getMongoOperations().remove(userId);
    }

    @Override
    public UserDetails getUserByEmail(String email) throws AppException {
        User user = this.getMongoOperations().findOne(
                new Query(Criteria.where("email").is(email)), User.class);

        return this.mappingUtil.map(user, UserDetails.class);
    }

}

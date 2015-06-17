package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;

public interface UserService {
    
    public boolean authenticateUser(String email, String password) throws AppException;
    
    public void saveUser(String userId, UserSaveDetails userSaveDetails) throws AppException;
    
    public UserDetails getUser(String userId) throws AppException;
    
    public List<UserDetails> listUsers() throws AppException;
    
    public void deleteUser(String userId) throws AppException;
    
    public UserDetails getUserByEmail(String email) throws AppException;
    
}

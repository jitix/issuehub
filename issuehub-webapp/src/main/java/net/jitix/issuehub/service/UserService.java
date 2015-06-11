package net.jitix.issuehub.service;

import java.util.List;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;

public interface UserService {
    
    public boolean authenticateUser(String email, String password);
    
    public void saveUser(UserSaveDetails userSaveDetails);
    
    public UserDetails getUser(String userId);
    
    public List<UserDetails> listUsers();
    
    public void deleteUser(String userId);
    
    public UserDetails getUserByEmail(String email);
    
}

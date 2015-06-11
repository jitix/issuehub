package net.jitix.issuehub.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.common.Constants;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.service.UserService;
import net.jitix.issuehub.util.ControllerUtil;
import net.jitix.issuehub.vo.AuthenticationRequest;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public UserDetails authenticate(@RequestBody AuthenticationRequest authRequest,
            HttpServletRequest request, HttpServletResponse response) {
        if (this.userService.authenticateUser(authRequest.getEmail(), authRequest.getPassword())) {
            UserDetails user = this.userService.getUserByEmail(authRequest.getEmail());

            //put user object in session
            request.getSession().setAttribute(Constants.USER_SESSION_ATTR_KEY, user);

            return user;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, 
            consumes = "application/json", produces="application/json")
    public UserDetails createUser(@RequestBody UserSaveDetails user,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException {
        ControllerUtil.checkAdminSession(request.getSession());

        this.userService.saveUser(user);
        
        return this.userService.getUserByEmail(user.getEmail());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<UserDetails> listUsers(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException {
        ControllerUtil.checkAdminSession(request.getSession());
        
        return this.userService.listUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateUserDetails(@PathVariable String userId, @RequestBody UserSaveDetails user,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException {
        
        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());
        
        this.userService.saveUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException {
        
        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());
        
        this.userService.deleteUser(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public UserDetails getUserDetails(@PathVariable String userId,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException {
        
        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());
        
        return this.userService.getUser(userId);
    }

}

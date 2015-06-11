package net.jitix.issuehub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.common.Constants;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.service.UserService;
import net.jitix.issuehub.util.ControllerUtil;
import net.jitix.issuehub.vo.AuthenticationRequest;
import net.jitix.issuehub.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public UserDetails createSession(@RequestBody AuthenticationRequest authRequest,
            HttpServletRequest request, HttpServletResponse response) throws AppException {
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
    
    @RequestMapping(value = "/remove", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public void removeSession(
            HttpServletRequest request, HttpServletResponse response) 
            throws AuthorizationException {
        ControllerUtil.checkValidSession(request.getSession());
        
        request.getSession().removeAttribute(Constants.USER_SESSION_ATTR_KEY);
        request.getSession().invalidate();
    }

}

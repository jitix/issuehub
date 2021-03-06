package net.jitix.issuehub.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.controller.exception.PermissionException;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.service.UserService;
import net.jitix.issuehub.util.ControllerUtil;
import net.jitix.issuehub.vo.UserDetails;
import net.jitix.issuehub.vo.UserSaveDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails createUser(@RequestBody UserSaveDetails user,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, Exception {
        ControllerUtil.checkAdminSession(request.getSession());

        this.userService.saveUser(null, user);

        return this.userService.getUserByEmail(user.getEmail());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDetails> listUsers(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, AppException {
        ControllerUtil.checkValidSession(request.getSession());

        return this.userService.listUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserDetails(@PathVariable String userId, @RequestBody UserSaveDetails userDetails,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, AppException {

        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());

        this.userService.saveUser(userId, userDetails);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, AppException {

        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());

        this.userService.deleteUser(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserDetails(@PathVariable String userId,
            HttpServletRequest request, HttpServletResponse response)
            throws AuthorizationException, PermissionException, AppException {

        ControllerUtil.checkValidSession(request.getSession());
        ControllerUtil.checkUserPermission(userId, request.getSession());

        return this.userService.getUser(userId);
    }

}

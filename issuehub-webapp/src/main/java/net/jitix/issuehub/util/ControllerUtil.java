package net.jitix.issuehub.util;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.jitix.issuehub.common.Constants;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.controller.exception.PermissionException;
import net.jitix.issuehub.vo.UserDetails;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ControllerUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerUtil.class);

    public static void checkAdminSession(HttpSession session)
            throws AuthorizationException, PermissionException {
        checkValidSession(session);

        if (Constants.SESSION_CHECK && !((UserDetails) session.getAttribute(Constants.USER_SESSION_ATTR_KEY))
                .getAdminFlag()) {
            throw new PermissionException();
        }
    }

    public static void checkValidSession(HttpSession session)
            throws AuthorizationException {
        if (Constants.SESSION_CHECK && !(session.getAttribute(Constants.USER_SESSION_ATTR_KEY) != null
                && session.getAttribute(Constants.USER_SESSION_ATTR_KEY) instanceof UserDetails)) {
            throw new AuthorizationException();
        }
    }

    public static void checkUserPermission(String userId, HttpSession session)
            throws PermissionException {
        //if there is a valid session then check the user type
        UserDetails sessionUser = (UserDetails) session
                .getAttribute(Constants.USER_SESSION_ATTR_KEY);

        if (!sessionUser.getAdminFlag()) {
            //if user is not admin and they are trying to modify another account
            if (Constants.SESSION_CHECK && !sessionUser.getUserId().equals(userId)) {
                throw new PermissionException();
            }
        }
    }

    public static UserDetails getSessionUserDetails(HttpSession session)
            throws AuthorizationException {
        if (Constants.SESSION_CHECK && !(session.getAttribute(Constants.USER_SESSION_ATTR_KEY) != null
                && session.getAttribute(Constants.USER_SESSION_ATTR_KEY) instanceof UserDetails)) {
            throw new AuthorizationException();
        } else {
            return (UserDetails) session
                    .getAttribute(Constants.USER_SESSION_ATTR_KEY);
        }
    }

    public static void putExceptionToResponse(HttpServletResponse response, HttpStatus status, Exception ex) {

        try {
            response.setStatus(status.value());

            if (ex != null) {
                LOG.error("Caught Exception: {}", ex.getMessage(), ex);

                if (StringUtils.isNotBlank(ex.getMessage())) {
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.getWriter().print("{\"msg\":\"" + StringEscapeUtils.escapeJson(ex.getMessage()) + "\"}");

                    response.getWriter().close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

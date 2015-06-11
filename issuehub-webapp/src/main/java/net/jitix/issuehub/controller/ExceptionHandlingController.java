package net.jitix.issuehub.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.controller.exception.PermissionException;
import net.jitix.issuehub.util.ControllerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public void handleAuthorizationException(
            HttpServletRequest request, HttpServletResponse response, Exception e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.UNAUTHORIZED, e);
    }

    //@ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(PermissionException.class)
    public void handlePermissionException(HttpServletRequest request, HttpServletResponse response, Exception e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.FORBIDDEN, e);
    }

    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

}

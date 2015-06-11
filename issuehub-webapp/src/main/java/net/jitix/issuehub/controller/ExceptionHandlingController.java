package net.jitix.issuehub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.jitix.issuehub.controller.exception.AuthorizationException;
import net.jitix.issuehub.controller.exception.PermissionException;
import net.jitix.issuehub.exception.AppException;
import net.jitix.issuehub.util.ControllerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(AuthorizationException.class)
    public void handleAuthorizationException(
            HttpServletRequest request, HttpServletResponse response, AuthorizationException e){
        System.out.println("ASDSADSAD");
        System.out.println("ASDSADSAD -->"+e.getMessage());
        e.printStackTrace();
        ControllerUtil.putExceptionToResponse(response,HttpStatus.UNAUTHORIZED, e);
    }

    @ExceptionHandler(PermissionException.class)
    public void handlePermissionException(HttpServletRequest request, HttpServletResponse response, PermissionException e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.FORBIDDEN, e);
    }
    
    @ExceptionHandler(AppException.class)
    public void handleAppException(HttpServletRequest request, HttpServletResponse response, AppException e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e){
        ControllerUtil.putExceptionToResponse(response,HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

}

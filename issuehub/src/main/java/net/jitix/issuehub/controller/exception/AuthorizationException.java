package net.jitix.issuehub.controller.exception;

import net.jitix.issuehub.exception.AppException;

public class AuthorizationException extends AppException{

    public AuthorizationException(String msg){
        super(msg);
    }
    
    public AuthorizationException(){
        super();
    }
}

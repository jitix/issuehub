package net.jitix.issuehub.controller.exception;

public class AuthorizationException extends Exception{

    public AuthorizationException(String msg){
        super(msg);
    }
    
    public AuthorizationException(){
        super();
    }
}

package net.jitix.issuehub.controller.exception;

import net.jitix.issuehub.exception.AppException;

public class PermissionException extends AppException {

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException() {
    }
}

package com.sns.online_store.exception;

public class BadRoleNameException extends BadApiRequestException {

    public BadRoleNameException(String badRoleName) {
        super(String.format("Role name '%s' is incorrect", badRoleName));
    }

}

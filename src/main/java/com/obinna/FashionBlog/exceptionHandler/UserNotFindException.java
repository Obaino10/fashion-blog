package com.obinna.FashionBlog.exceptionHandler;

public class UserNotFindException extends RuntimeException{
    public UserNotFindException(String message) {
        super(message);
    }
}

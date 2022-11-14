package com.obinna.FashionBlog.exceptionHandler;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message){
        super(message);
    }
}

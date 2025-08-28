package com.Project.Ecommerce.Exceptions;

public class NoExistentProductException extends RuntimeException {
    public NoExistentProductException(String s) {
        super(s);
    }
}

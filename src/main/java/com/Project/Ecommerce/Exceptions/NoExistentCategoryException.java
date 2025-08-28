package com.Project.Ecommerce.Exceptions;

public class NoExistentCategoryException extends RuntimeException {
    public NoExistentCategoryException(String msg) {
        super(msg);
    }
}

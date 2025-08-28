package com.Project.Ecommerce.infrastructure;

import com.Project.Ecommerce.Exceptions.ExceptionBody;
import com.Project.Ecommerce.Exceptions.NoExistentCategoryException;
import com.Project.Ecommerce.Exceptions.NoExistentProductException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.Instant;

@RestControllerAdvice//this class treat exceptions in all app
public class ExceptionAppCatcher {


    @ExceptionHandler(NoExistentProductException.class)
    public ResponseEntity<ExceptionBody> noExistentProductCatch(NoExistentProductException e, HttpServletRequest pathError)
    {
        String msg = "not found";
        ExceptionBody exception = new ExceptionBody(Instant.now(), 500, msg, e.getMessage(), pathError.getRequestURI());
        return ResponseEntity.status(500).body(exception);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionBody> NoResourceFoundException(NoResourceFoundException e, HttpServletRequest path)
    {
        String msg = "Not found resource";
        return ResponseEntity.status(404).body(new ExceptionBody(Instant.now(), 404, msg, e.getMessage(), path.getRequestURI()));
    }

    @ExceptionHandler(NoExistentCategoryException.class)
    public ResponseEntity<ExceptionBody> NoExistentCategoryException(NoExistentCategoryException e, HttpServletRequest path)
    {
        String msg = "Not found resource";
        return ResponseEntity.status(404).body(new ExceptionBody(Instant.now(), 404, msg, e.getMessage(), path.getRequestURI()));
    }
}

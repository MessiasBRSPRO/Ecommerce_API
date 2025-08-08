package com.Project.Ecommerce.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> helloWorldEndpoint(){
        return ResponseEntity.ok("Hello world endpoint ;)");
    }
}

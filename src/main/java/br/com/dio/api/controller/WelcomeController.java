package br.com.dio.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> getMensage(){
        return ResponseEntity.ok().body("Welcome to my first REST API documented with Swagger");
    }
    
}

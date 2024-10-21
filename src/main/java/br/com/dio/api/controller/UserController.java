package br.com.dio.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.api.model.User;

import br.com.dio.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.all();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<User> userOptional = service.get(id);
        if (!userOptional.isPresent()) { // Verifica se o Optional está vazio
            return ResponseEntity.status(404).body("No user found!"); // Retorna 404 se o usuário não for encontrado
        }
        return ResponseEntity.ok().body(userOptional.get()); // Retorna o usuário se encontrado
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User savedUser = service.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }



}

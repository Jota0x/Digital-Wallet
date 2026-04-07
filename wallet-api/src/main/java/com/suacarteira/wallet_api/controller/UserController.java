package com.suacarteira.wallet_api.controller;

import com.suacarteira.wallet_api.model.User;
import com.suacarteira.wallet_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Injeção de dependência do Service
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User user) {
        User novoUsuario = userService.criarUsuario(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    
    @GetMapping
    public ResponseEntity<List<User>> listarTodos() {
        List<User> usuarios = userService.listar();
        return ResponseEntity.ok(usuarios);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable UUID id) {
        return userService.buscarId(id)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        userService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}
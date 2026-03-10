package com.suacarteira.wallet_api.controller;

import com.suacarteira.wallet_api.model.User;
import com.suacarteira.wallet_api.repository.UserRepository;
import com.suacarteira.wallet_api.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Recebe pedido HHTP Request e leva para o Service
@RestController                                         //Converte retorno dos métodos para JSON
@RequestMapping("/users")                               //Define a rota 
public class UserController {

    @Autowired      //Injeção de dependência                             
    private UserRepository userRepository;

    // Rota para listar todos os usuários
    @GetMapping     //Mapeia HHTP GET
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Rota para criar um novo usuário
    @PostMapping    //Mapeia HHTP POST
    public User createUser(@RequestBody UserRequestDTO data) { //"Encaixa" JSON recebido pelo usuário em UserRequestDTO

        //Transforma DTO em Entidade
        User newUser = new User();
        newUser.setTitular(data.titular());
        newUser.setEmail(data.email());
        newUser.setSaldo(data.saldoInicial());
        
        //INSERT INTO 
        return userRepository.save(newUser);
    }

}

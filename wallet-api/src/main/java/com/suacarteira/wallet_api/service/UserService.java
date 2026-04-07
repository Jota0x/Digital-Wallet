package com.suacarteira.wallet_api.service;

import com.suacarteira.wallet_api.model.User;
import com.suacarteira.wallet_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Cria Usuario
    @Transactional
    public User criarUsuario(User user) {

        // Verifica c email ja esta cadastrado
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Este e-mail já está cadastrado!");
        }

        if (user.getSaldo() == null) {
            user.setSaldo(java.math.BigDecimal.ZERO);
        }

        return userRepository.save(user);

    }

    // Lista todos
    public List<User> listar() {
        return userRepository.findAll();
    }

    // Busca por id
    public Optional<User> buscarId(UUID id) {
        return userRepository.findById(id);
    }

    // Deleta Usuario
    @Transactional
    public void deletarUsuario(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
                
        userRepository.delete(user);
    }

}
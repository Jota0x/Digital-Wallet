package com.suacarteira.wallet_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suacarteira.wallet_api.model.User;

import java.util.UUID;


//Abstrai armazenamento para banco de dados
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
}

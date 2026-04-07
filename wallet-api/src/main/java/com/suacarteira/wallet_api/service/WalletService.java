package com.suacarteira.wallet_api.service;


import com.suacarteira.wallet_api.model.User;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.suacarteira.wallet_api.repository.UserRepository;


@Service
public class WalletService {

    private final UserRepository userRepository;

    public WalletService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void transfer(UUID PagadorId, UUID BeneficiarioId, BigDecimal saldo) {
        User sender = userRepository.findById(PagadorId)
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));
        
        User receiver = userRepository.findById(BeneficiarioId)
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        if (sender.getSaldo().compareTo(saldo) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // Atualiza os saldos
        sender.setSaldo(sender.getSaldo().subtract(saldo));
        receiver.setSaldo(receiver.getSaldo().add(saldo));

        // Salva as alterações
        userRepository.save(sender);
        userRepository.save(receiver);
    }
}

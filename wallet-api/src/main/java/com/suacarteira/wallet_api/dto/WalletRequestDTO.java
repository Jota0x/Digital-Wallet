package com.suacarteira.wallet_api.dto;

import java.math.BigDecimal;

public record WalletRequestDTO(String nome, String email, BigDecimal saldo) {} 
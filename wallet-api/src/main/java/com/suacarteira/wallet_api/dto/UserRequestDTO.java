package com.suacarteira.wallet_api.dto;

import java.math.BigDecimal;

//Carrega dados de JSON
//Cria automaticamente os métodos para ler os dados
public record UserRequestDTO(String titular, String email, BigDecimal saldoInicial){} 



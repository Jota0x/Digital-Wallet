package com.suacarteira.wallet_api.model;
import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;


@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String email; 

    private BigDecimal saldo;

    //Construtor padrao
    public User() {}
    public User(UUID id, String nome, String senha, String email, BigDecimal saldo){

        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.saldo = saldo;

    }

    //setters
    public void setId(UUID id)              {this.id = id;}
    public void setNome(String nome)        {this.nome = nome;}
    public void setSenha(String senha)      {this.senha = senha;}
    public void setEmail(String email)      {this.email = email;}
    public void setSaldo(BigDecimal saldo)  {this.saldo = saldo;}

    //setters   
    public UUID getId()           {return this.id;}
    public String getNome()       {return this.nome;}
    public String getSeha()       {return this.senha;}
    public String getEmail()      {return this.email;}
    public BigDecimal getSaldo()  {return this.saldo;}


}

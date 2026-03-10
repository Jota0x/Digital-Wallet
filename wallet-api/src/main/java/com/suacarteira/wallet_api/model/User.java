package com.suacarteira.wallet_api.model;

//import para Spring 
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


@Entity                         //Entidade do banco de dados
@Table(name = "tb_users")       //Endereço da tabela 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;                //UUID evita duplicação

    @NotBlank(message = "TITULAR OBRIGATORIO")
    private String titular;         //Nome titular

    @NotNull
    @PositiveOrZero(message = "SALDO NAO PODE SER NEGATIVO")
    private BigDecimal saldo;       //Saldo


    @Column(unique = true,nullable= false)  //Email unico por usuario
    @NotBlank(message = "EMAIL OBRIGATORIO")
    private String email;           //Email

    //setters
    public void setID(UUID id)              {this.id = id;};
    public void setTitular(String titular)  {this.titular = titular;}
    public void setSaldo(BigDecimal saldo)  {this.saldo = saldo;}
    public void setEmail(String email)      {this.email = email;}

    //getters
    public UUID getID()            {return this.id;}
    public String getTitular()     {return this.titular;}
    public BigDecimal getSaldo()   {return this.saldo;}
    public String getEmail()       {return this.email;}

    //construtores
    public User() {}

    public User(UUID id,String titular,BigDecimal saldo,String email){

        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
        this.email = email;

    }








}

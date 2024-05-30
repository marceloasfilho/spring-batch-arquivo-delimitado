package com.github.marceloasfilho.springbatcharquivodelimitado.entity;

import lombok.Data;

@Data
public class Cliente {
    private String nome;
    private String sobrenome;
    private int idade;
    private String email;
}

package com.amd.desafio1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String nome;
    public String cpf;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String uf;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Telefone> telefone = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Email> email;
}

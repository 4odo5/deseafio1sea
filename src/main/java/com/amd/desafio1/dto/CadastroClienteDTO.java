package com.amd.desafio1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CadastroClienteDTO {

    @NotNull
    @Min(3)
    @Max(100)
    public String nome;
    @NotNull
    @Max(11)
    public String cpf;
    @NotNull
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String uf;
    public List<String> telefone;
    public List<String> email;

}

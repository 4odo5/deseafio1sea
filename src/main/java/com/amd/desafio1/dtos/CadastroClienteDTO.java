package com.amd.desafio1.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = false)
public class CadastroClienteDTO {

    @NotNull
    public String nome;
    @NotNull
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

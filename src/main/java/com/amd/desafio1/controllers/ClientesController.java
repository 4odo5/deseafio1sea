package com.amd.desafio1.controllers;

import com.amd.desafio1.dto.CadastroClienteDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClientesController {

    @PostMapping("cadastroCliente")
    public ResponseEntity<String> cadastroCliente(@Valid @RequestBody CadastroClienteDTO clienteDTO){

        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }

}

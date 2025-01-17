package com.amd.desafio1.controllers;

import com.amd.desafio1.dtos.CadastroClienteDTO;
import com.amd.desafio1.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("cadastroCliente")
    public ResponseEntity<String> cadastroCliente(@Valid @RequestBody CadastroClienteDTO clienteDTO){

        clienteService.save(clienteDTO);

        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }

    @GetMapping("buscarClientes")
    public ResponseEntity<List<CadastroClienteDTO>> buscarClientes(){
        List<CadastroClienteDTO> retorno = clienteService.findAll();

        return ResponseEntity.ok(retorno);
    }

}

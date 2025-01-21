package com.amd.desafio1.services;

import com.amd.desafio1.dtos.CadastroClienteDTO;
import com.amd.desafio1.entities.Cliente;
import com.amd.desafio1.entities.Email;
import com.amd.desafio1.entities.Telefone;
import com.amd.desafio1.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CadastroClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(entidade -> modelMapper.map(entidade, CadastroClienteDTO.class))
                .collect(Collectors.toList());
    }

    public void save(CadastroClienteDTO cliente) {

        Cliente clienteEntity = new Cliente();
        clienteEntity.setNome(cliente.getNome());

        List<Email> emails = new ArrayList<>();
        for (String e : cliente.getEmail()) {
            Email email = new Email();
            email.setEmail(e);
            emails.add(email);
        }

        List<Telefone> telefones = new ArrayList<>();
        for (String e : cliente.getTelefone()) {
            Telefone telefone = new Telefone();
            telefone.setTelefone(e);
            telefones.add(telefone);
        }
        clienteEntity.setEmail(emails);
        clienteEntity.setTelefone(telefones);

        clienteRepository.save(clienteEntity);
    }

}

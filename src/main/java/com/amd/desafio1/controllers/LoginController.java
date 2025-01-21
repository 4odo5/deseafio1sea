package com.amd.desafio1.controllers;

import com.amd.desafio1.dtos.LoginDTO;
import com.amd.desafio1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> autenticarUsuario(@RequestBody LoginDTO login){
        String token = userService.autenticarUsuario(login);
        return ResponseEntity.ok(token);
    }


}

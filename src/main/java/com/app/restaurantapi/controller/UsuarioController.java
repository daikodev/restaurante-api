package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.Usuario;
import com.app.restaurantapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String nombre, @RequestParam String contrasena) {
        Usuario usuario = usuarioService.validateUser(nombre, contrasena);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.status(401).build();
    }
}

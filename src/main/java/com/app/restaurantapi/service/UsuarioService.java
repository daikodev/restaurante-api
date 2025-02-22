package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.Usuario;
import com.app.restaurantapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validateUser(String nombre, String contrasena) {
        return usuarioRepository.validateUser(nombre, contrasena);
    }
}

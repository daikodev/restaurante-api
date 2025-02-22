package com.app.restaurantapi.repository;

import com.app.restaurantapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contrasena = :contrasena")
    public Usuario validateUser(@Param("nombre") String nombre,@Param("contrasena") String contrasena);
}

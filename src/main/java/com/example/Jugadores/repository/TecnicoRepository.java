package com.example.Jugadores.repository;

import com.example.Jugadores.entidades.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    // para crear un nuevo tecnico usamos .save()
    @Query("Select t from Tecnico t WHERE t.nombre = ?1 ")
    Optional<Tecnico> buscarTecnicoNombre(String nombre);
}

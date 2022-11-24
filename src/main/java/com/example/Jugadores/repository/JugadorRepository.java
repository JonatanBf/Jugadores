package com.example.Jugadores.repository;

import com.example.Jugadores.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador,Long> {
}

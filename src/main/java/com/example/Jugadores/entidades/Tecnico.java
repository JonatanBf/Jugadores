package com.example.Jugadores.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tecnicos")
@Getter
@Setter
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // utiliza una secuencia de base de datos para generar valores únicos
    private Long id;

    @Column
    private String nombre;

    @Column
    private int edad;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

}

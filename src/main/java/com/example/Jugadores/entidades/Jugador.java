package com.example.Jugadores.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="jugadores")
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String clubFavorito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "tecnico_id")
    private Tecnico tecnico;

}

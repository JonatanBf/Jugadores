package com.example.Jugadores.service;

import com.example.Jugadores.entidades.Jugador;
import com.example.Jugadores.entidades.Tecnico;
import com.example.Jugadores.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //para inyectar dependencias
public class TecnicoService {

    @Autowired
    TecnicoRepository repository;

    public Tecnico guardar(Tecnico t){
        return repository.save(t); //metodo guardar
    }

    public List<Tecnico> obtenerTodosTecnicos(){
        return repository.findAll(); // obtener todos
    }

    public Tecnico buscarTecnicoNombre (String nombre){
        return repository.buscarTecnicoNombre(nombre).get();
    }

    public String borrar(Long id){
        repository.deleteById(id);
        return "ok";
    }

    public Tecnico agregarJugadorAlTecnico(Long id, Jugador j){
        Optional<Tecnico> t = repository.findById(id); //busco al tecnico
        j.setTecnico(t.get()); // agrego el tecnico a jugador
        t.get().getJugadores().add(j); // agrego el jugador al tecnico
        return repository.save(t.get()); // guardo el tecnico
    }
}

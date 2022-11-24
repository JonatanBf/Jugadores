package com.example.Jugadores.controller;

import com.example.Jugadores.entidades.Jugador;
import com.example.Jugadores.entidades.Tecnico;
import com.example.Jugadores.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tecnicos")
public class TecnicoController {

    @Autowired
    TecnicoService service;

    @GetMapping("/Listar")
    public ResponseEntity<List<Tecnico>> traerTecnicos(){
        return ResponseEntity.ok(service.obtenerTodosTecnicos());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Tecnico> traerTecnicoNombre(@PathVariable String nombre){
        Tecnico tec = service.buscarTecnicoNombre(nombre);
        if ( tec!= null){
            return ResponseEntity.ok(tec);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/Crear")
    public ResponseEntity<Tecnico> crearTecnico(@RequestBody Tecnico t ){
        return ResponseEntity.ok(service.guardar(t));
    }

    @PostMapping("/AgregarJugador/{id}")
    public ResponseEntity<Tecnico> agregarJugador(@RequestBody Jugador j, @PathVariable Long id){
            return ResponseEntity.ok(service.agregarJugadorAlTecnico(id,j));
        }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarTecnico(@PathVariable Long id){
        ResponseEntity<String> respuesta = null;
        if (service.borrar(id)!= null){
            respuesta = ResponseEntity.ok("Se borro el tecnico sin problemas");
        }else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo borrar al tecnico");
        }
        return respuesta;
    }


    }


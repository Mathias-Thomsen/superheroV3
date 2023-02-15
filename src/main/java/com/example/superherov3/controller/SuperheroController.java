package com.example.superherov3.controller;

import com.example.superherov3.model.Superhero;
import com.example.superherov3.services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea") //localhost:8080/kea
public class SuperheroController {

    private final SuperheroService superheroService;


    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;

    }


    @GetMapping (path = "superhero") //localhost:8080/kea/superhero
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroList = superheroService.getSuperheros();

        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);

    }

    @GetMapping (path = "superhero/{superheroName}") //localhost:8080/kea/superhero/superman
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String superheroName){
        Superhero returnSuperhero = superheroService.getSuperhero(superheroName);
        return new ResponseEntity<Superhero>(returnSuperhero, HttpStatus.OK);
    }


    @PostMapping (path = "superhero/opret") //localhost:8080/kea/superhero/opret

    public ResponseEntity<Superhero> postSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.addSuperhero(superhero);
        return new ResponseEntity<Superhero>(returnSuperhero, HttpStatus.OK);
    }

    @PutMapping (path = "superhero/ret") //localhost:8080/kea/superhero/ret

    public ResponseEntity<Superhero> putSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.putSuperhero(superhero);
        return new ResponseEntity<Superhero>(returnSuperhero, HttpStatus.OK);
    }




}

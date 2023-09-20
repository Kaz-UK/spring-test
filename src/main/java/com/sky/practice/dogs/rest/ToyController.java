package com.sky.practice.dogs.rest;

import com.sky.practice.dogs.domain.Dog;
import com.sky.practice.dogs.domain.Toy;
import com.sky.practice.dogs.services.ToyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping ("/toy")
public class ToyController {

    private ToyService service;

    public ToyController(ToyService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Toy> createToy(@RequestBody Toy t) {
        return new ResponseEntity<>(this.service.createToy(t), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Toy>getAllToys() {
        return this.service.getAllToys();
    }
}

package com.sky.practice.dogs.rest;

import com.sky.practice.dogs.domain.Toy;
import com.sky.practice.dogs.services.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/toy")
public class ToyController {

    private ToyService service;

    public ToyController(ToyService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Toy createToy(@RequestBody Toy t) {
        return this.service.createToy(t);
    }

    @GetMapping("/get")
    public List<Toy>getToys() {
        return this.service.getToys();
    }
}

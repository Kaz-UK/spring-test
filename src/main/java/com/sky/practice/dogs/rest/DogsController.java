package com.sky.practice.dogs.rest;

import com.sky.practice.dogs.domain.Dog;
import com.sky.practice.dogs.services.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogsController {

    private DogService service;

    public DogsController(DogService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String test() {

        return "Hello, World!";
    }

    @PostMapping("/create")
    public ResponseEntity<Dog> createDog(@RequestBody Dog d){
        return new ResponseEntity<>(this.service.createDog(d) , HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable int id) {
        Dog search = this.service.getDog(id);
        if (search == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(search);
    }

    @GetMapping("/getAll")
    public List<Dog> getDogs() {
        return this.service.getAll();
    }

    @PatchMapping("/update")
    public ResponseEntity<Dog> updateDog(
            @RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "breed", required = false) String breed,
            @RequestParam(name = "age", required = false) Integer age
    ) {

        Dog patchUpdate = this.service.updateDog(id, name, breed, age);
        if (patchUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(patchUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeDog(@PathVariable int id) {
        String result = this.service.removeDog (id);
        if ("NOT FOUND".equalsIgnoreCase(result)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return ResponseEntity.ok(result);


    }

}

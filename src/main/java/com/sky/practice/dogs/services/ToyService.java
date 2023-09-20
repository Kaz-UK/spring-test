package com.sky.practice.dogs.services;

import com.sky.practice.dogs.domain.Toy;
import com.sky.practice.dogs.repo.ToyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    private ToyRepo repo;

    public ToyService(ToyRepo repo) {
        this.repo = repo;
    }

    public Toy createToy(Toy t) {
        return this.repo.save(t);
    }

    public List<Toy>getToys() {
        return this.repo.findAll();
    }

}
package com.sky.practice.dogs.services;

import com.sky.practice.dogs.domain.Dog;

import java.util.List;

public interface DogService {

    Dog createDog(Dog d);

    Dog getDog(Integer id);

    List<Dog> getAll();

    Dog updateDog(
            Integer id,
            String name,
            String breed,
            Integer age
    );

    String removeDog(Integer id);

}

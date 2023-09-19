package com.sky.practice.dogs.services;

import com.sky.practice.dogs.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceList implements DogService {

    private List<Dog> dogs = new ArrayList<>();

    @Override
    public Dog createDog(Dog d) {
        dogs.add(d);
        Dog created = this.dogs.get(this.dogs.size() - 1);
        return created;
    }

    @Override
    public Dog getDog(int id) {
        if (id >= this.dogs.size()) {
            return this.dogs.get(id);
        } else return null;
    }

    @Override
    public List<Dog> getAll() {
        return this.dogs;
    }

    @Override
    public Dog updateDog(
            Integer id,
            String name,
            String breed,
            Integer age
    ) {
        if (id >= this.dogs.size()) {
            return null;
        }

        Dog dogPatch = getDog(id);
        if (name != null) dogPatch.setName(name);
        if (breed != null) dogPatch.setBreed(breed);
        if (age != null) dogPatch.setAge(age);

        return this.dogs.get(id);
    }

    @Override
    public String removeDog(int id) {
        if (dogs.remove(id) != null) {
            return "Dog deleted";
        } else {
            return "Error, dog not found";
        }
    }

}
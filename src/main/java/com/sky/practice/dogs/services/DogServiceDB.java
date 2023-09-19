package com.sky.practice.dogs.services;

import com.sky.practice.dogs.domain.Dog;
import com.sky.practice.dogs.repo.DogsRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@Primary
public class DogServiceDB implements DogService {

    private DogsRepo repo;

    public DogServiceDB(DogsRepo repo) {
        this.repo = repo;
    }

    @Override
    public Dog createDog(Dog d) {
        return this.repo.save(d);
    }

    @Override
    public Dog getDog(Integer id) {
        Optional<Dog> searchResult = this.repo.findById(id);
        return searchResult.get();
    }

//    @Override
//    public Dog findDogByName(String name) {
//        return this.repo.findByNameIgnoreCase(name);
//    }

    @Override
    public List<Dog> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Dog updateDog(Integer id, String name, String breed, Integer age)  {
        Dog toPatch = this.getDog(id);

        if (name != null) toPatch.setName(name);
        if (breed != null) toPatch.setBreed(breed);
        if (age != null) toPatch.setAge(age);


        return this.repo.save(toPatch);
    }

    @Override
    public String removeDog(Integer id) {
        if (this.repo.existsById(id)) {
            this.repo.deleteById(id);
            return "This dog has been removed from the database";
        } else {
            return "No such dog exists, please try again";
        }
    }

}

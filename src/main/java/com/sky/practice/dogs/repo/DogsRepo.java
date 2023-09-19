package com.sky.practice.dogs.repo;

import com.sky.practice.dogs.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogsRepo extends JpaRepository<Dog, Integer> {

}

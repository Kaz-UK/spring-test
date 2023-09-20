package com.sky.practice.dogs.repo;

import com.sky.practice.dogs.domain.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepo extends JpaRepository<Toy, Integer> {
}

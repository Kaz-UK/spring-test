package com.sky.practice.dogs.domain;

import javax.persistence.Entity;
import javax.persistence.*;

// @Entity creates the link to the database tables
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String breed;

    private int age;

    public Dog(Integer id, String name, String breed, int age) {
        super();
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Dog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

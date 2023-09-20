package com.sky.practice.dogs.domain;

import javax.persistence.*;

@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String toyName;

    private String toyCondition;

    @ManyToOne
    private Dog owner;

    public Toy() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public String getToyCondition() {
        return toyCondition;
    }

    public void setCondition(String condition) {
        this.toyCondition = condition;
    }

    public Dog getOwner() {
        return owner;
    }

    public void setOwner(Dog owner) {
        this.owner = owner;
    }
}

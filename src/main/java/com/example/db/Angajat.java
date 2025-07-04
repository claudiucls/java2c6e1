package com.example.db;

import jakarta.persistence.*;

@MappedSuperclass
//specifica JPA ca aceasta clasa va fi mostenita de entitati
// dar ea in sine nu este o entitate

public abstract class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

package com.example.db;

import jakarta.persistence.Entity;

@Entity
public class Avocat extends Angajat{

    private int vechime;

    public int getVechime() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }
}

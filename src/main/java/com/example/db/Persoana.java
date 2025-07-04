package com.example.db;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Persoana {

    @EmbeddedId //marcam cheia primara compusa
    private NumePrenumeId id;

    private String varsta;

    public NumePrenumeId getId() {
        return id;
    }

    public void setId(NumePrenumeId id) {
        this.id = id;
    }

    public String getVarsta() {
        return varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta = varsta;
    }
}

package com.example.db;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name="Bere.findAll",query = "SELECT b FROM Bere b")
})
public class Bere extends Produs{

    private int alcool;

    public int getAlcool() {
        return alcool;
    }

    public void setAlcool(int alcool) {
        this.alcool = alcool;
    }

    @Override
    public String toString() {
        return "Bere{" + super.toString() +
                "alcool=" + alcool +
                "} " ;
    }
}

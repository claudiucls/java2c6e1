package com.example.main;

import com.example.db.Bere;
import com.example.db.Ciocolata;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {

                var c = new Ciocolata();

                c.setNume("Milka");
                c.setZahar(20);

                var b = new Bere();
                b.setNume("Stejar");
                b.setAlcool(7);

                em.getTransaction().begin();

                em.persist(c);
                em.persist(b);

                em.getTransaction().commit();
            }
        }


    }
}
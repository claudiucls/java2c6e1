package com.example.main;

import com.example.db.Avocat;
import com.example.db.Programator;
import jakarta.persistence.Persistence;

public class Main2 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {

                Programator p = new Programator();
                p.setNume("Claudiu");
                p.setLimbaj("Java");

                Avocat a = new Avocat();
                a.setVechime(4);
                a.setNume("Dl. Vasilescu");

                em.getTransaction().begin();
                em.persist(p);
                em.persist(a);
                em.getTransaction().commit();
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

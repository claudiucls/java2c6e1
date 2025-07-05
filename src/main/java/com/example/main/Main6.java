package com.example.main;

import com.example.db.Bere;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main6 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {
                em.getTransaction().begin();

                TypedQuery<Bere> q = em.createNamedQuery("Bere.findAll", Bere.class);

                List<Bere> resultList = q.getResultList();

                resultList.forEach(System.out::println);

                em.getTransaction().commit();
            }
        }
    }
}

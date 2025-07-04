package com.example.main;

import com.example.db.Bere;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

/*
    JPQL - Java Persistence Query Language
      - este o abstractizare a limbajelor sql
      - foloseste entitatile definite
 */
public class Main5 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {
                // "SELECT * FROM bere
                String sql = "SELECT b FROM Bere b";

                em.getTransaction().begin();
                TypedQuery<Bere> query = em.createQuery(sql, Bere.class);

                List<Bere> resultList = query.getResultList();

                resultList.forEach(System.out::println);


                em.getTransaction().commit();

            }
        }
    }
}

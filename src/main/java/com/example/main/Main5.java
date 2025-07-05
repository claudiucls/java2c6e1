package com.example.main;

import com.example.db.Bere;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

/*
    JPQL - Java Persistence Query Language
      - este o abstractizare a limbajelor sql
      - foloseste entitatile definite
      - pot fi folosite doare pentru SELECT UPDATE sau DELETE
       - nu este acceptat INSERT
       - nu actualizeaza contextul
 */
public class Main5 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {
                // "SELECT * FROM bere
                String sql = "SELECT b FROM Bere b";
                // in loc de Bere se poate folosi Produs
                // si resultatul este cel asteptat
                // adica va afisa toate Berile si toate Ciocolatele
                // in spate va face un UNION ALL
                em.getTransaction().begin();
                TypedQuery<Bere> query = em.createQuery(sql, Bere.class);

                List<Bere> resultList = query.getResultList();

                resultList.forEach(System.out::println);


                em.getTransaction().commit();

                em.clear();

                String sql2 ="SELECT b FROM Bere b WHERE b.alcool = ?1 AND b.nume =:nume";


                em.getTransaction().begin();

                TypedQuery<Bere> bere = em.createQuery(sql2, Bere.class);
                bere.setParameter(1, 5);
                bere.setParameter("nume","Tuborg");

                List<Bere> beri = bere.getResultList();

                beri.forEach(System.out::println);

                em.getTransaction().commit();


            }
        }
    }
}

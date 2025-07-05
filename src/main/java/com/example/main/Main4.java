package com.example.main;

import com.example.db.Bere;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class Main4 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {

//                Bere b = new Bere();
//                b.setAlcool(4);
//                b.setNume("Stella Artois");
//
//
//                em.getTransaction().begin();
//                em.persist(b);
//                em.getTransaction().commit();
//
//                em.clear();


                // String sql = "SELECT * FROM bere";
                String sql = "SELECT * FROM bere WHERE nume = ?";

                em.getTransaction().begin();
                Query q = em.createNativeQuery(sql, Bere.class);
                q.setParameter(1,"Stejar");

                var singleResult = (Bere) q.getSingleResult();

                System.out.println(singleResult);

                //List<Bere> beri = q.getResultList();
                //beri.forEach(System.out::println);

                em.getTransaction().commit();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

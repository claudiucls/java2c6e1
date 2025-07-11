package com.example.main;

import com.example.db.NumePrenumeId;
import com.example.db.Persoana;
import com.example.db.Student;
import jakarta.persistence.Persistence;

public class Main3 {

    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {
                Persoana p = new Persoana();

                NumePrenumeId id = new NumePrenumeId();
                id.setNume("Georgescu");
                id.setPrenume("Simion");

                p.setId(id);
                p.setVarsta("35");

                Student s = new Student();
                s.setNume("Popescu");
                s.setPrenume("Maria");

                em.getTransaction().begin();
                //em.persist(p);
                em.persist(s);
                em.getTransaction().commit();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

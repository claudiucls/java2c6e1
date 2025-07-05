package com.example.main;

import com.example.db.Bere;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

import java.util.List;

/*
    Criteria API - un set de API prin care se pot
            defini interogari in mod programatic
 */
public class Main7 {
    public static void main(String[] args) {
        try (var emf = Persistence.createEntityManagerFactory("java2c6PU")) {
            try (var em = emf.createEntityManager()) {


                // SELECT b FROM Bere b WHERE b.nume = 'Stejar'

                // CriteriaBuilder este clasa care cosntruieste
                // clauzele interogarii: equal, greaterThan, notNull,...
                em.getTransaction().begin();

                CriteriaBuilder cb = em.getCriteriaBuilder();

                CriteriaQuery<Bere> query = cb.createQuery(Bere.class);
                Root<Bere> b = query.from(Bere.class);
                query.select(b)
                        .where(cb.equal(b.get("nume"),"Stejar"));

                TypedQuery<Bere> q = em.createQuery(query);
                List<Bere> resultList = q.getResultList();

                resultList.forEach(System.out::println);

                em.getTransaction().commit();


            }
        }
    }
}

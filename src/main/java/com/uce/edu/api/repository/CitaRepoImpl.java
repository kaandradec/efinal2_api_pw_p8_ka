package com.uce.edu.api.repository;

import java.util.List;

import com.uce.edu.api.repository.model.Cita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CitaRepoImpl implements ICitaRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insertar(Cita cita) {
        this.entityManager.persist(cita);
    }

    @Override
    public List<Cita> seleccionarTodas() {
        TypedQuery<Cita> query = this.entityManager.createQuery("SELECT c FROM Cita c",
                Cita.class);

        return query.getResultList();
    }

}

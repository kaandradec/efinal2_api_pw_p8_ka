package com.uce.edu.api.repository;

import java.util.List;

import com.uce.edu.api.repository.model.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insertar(Paciente paciente) {
        this.entityManager.persist(paciente);
    }

    @Override
    public Paciente seleccionarPorCedula(String cedula) {
        TypedQuery<Paciente> query = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula=:cedula",
                Paciente.class);

        query.setParameter("cedula", cedula);

        List<Paciente> pacientes = query.getResultList();

        return pacientes.isEmpty() ? null : pacientes.get(0);
    }

}

package com.uce.edu.api.repository;

import java.util.List;

import com.uce.edu.api.repository.model.Doctor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insertar(Doctor paciente) {
        this.entityManager.persist(paciente);
    }

    @Override
    public Doctor seleccionarPorCedula(String cedula) {
        TypedQuery<Doctor> query = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula=:cedula",
                Doctor.class);

        query.setParameter("cedula", cedula);

        List<Doctor> pacientes = query.getResultList();

        return pacientes.isEmpty() ? null : pacientes.get(0);
    }

}

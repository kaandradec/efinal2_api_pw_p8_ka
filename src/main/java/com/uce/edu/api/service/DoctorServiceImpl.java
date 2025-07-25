package com.uce.edu.api.service;

import com.uce.edu.api.repository.IDoctorRepo;
import com.uce.edu.api.repository.model.Doctor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DoctorServiceImpl implements IDoctorService {

    @Inject
    private IDoctorRepo iDoctorRepo;

    @Override
    public void guardar(Doctor paciente) {
        this.iDoctorRepo.insertar(paciente);
    }

    @Override
    public Doctor buscarPorCedula(String cedula) {
        return this.iDoctorRepo.seleccionarPorCedula(cedula);
    }

}

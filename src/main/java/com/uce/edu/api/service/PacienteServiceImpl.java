package com.uce.edu.api.service;

import com.uce.edu.api.repository.IPacienteRepo;
import com.uce.edu.api.repository.model.Paciente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PacienteServiceImpl implements IPacienteService {

    @Inject
    private IPacienteRepo iPacienteRepo;

    @Override
    public void guardar(Paciente paciente) {
        this.iPacienteRepo.insertar(paciente);
    }

    @Override
    public Paciente buscarPorCedula(String cedula) {
        return this.iPacienteRepo.seleccionarPorCedula(cedula);
    }

}

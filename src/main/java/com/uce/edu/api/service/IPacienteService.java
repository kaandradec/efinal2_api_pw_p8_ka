package com.uce.edu.api.service;

import com.uce.edu.api.repository.model.Paciente;

public interface IPacienteService {
    void guardar(Paciente paciente);

    Paciente buscarPorCedula(String cedula);
}

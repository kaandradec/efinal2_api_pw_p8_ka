package com.uce.edu.api.repository;

import com.uce.edu.api.repository.model.Paciente;

public interface IPacienteRepo {
    void insertar(Paciente paciente);

    Paciente seleccionarPorCedula(String cedula);
}

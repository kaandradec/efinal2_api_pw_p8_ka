package com.uce.edu.api.repository;

import com.uce.edu.api.repository.model.Doctor;

public interface IDoctorRepo {
    void insertar(Doctor doctor);

    Doctor seleccionarPorCedula(String cedula);
}

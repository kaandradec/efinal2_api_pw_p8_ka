package com.uce.edu.api.service;

import com.uce.edu.api.repository.model.Doctor;

public interface IDoctorService {
    void guardar(Doctor doctor);

    Doctor buscarPorCedula(String cedula);
}

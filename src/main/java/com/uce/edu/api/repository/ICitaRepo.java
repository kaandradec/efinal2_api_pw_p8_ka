package com.uce.edu.api.repository;

import java.util.List;

import com.uce.edu.api.repository.model.Cita;

public interface ICitaRepo {
    void insertar(Cita cita);

    List<Cita> seleccionarTodas();
}

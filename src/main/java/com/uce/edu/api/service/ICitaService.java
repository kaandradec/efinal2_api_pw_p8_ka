package com.uce.edu.api.service;

import java.util.List;

import com.uce.edu.api.repository.model.Cita;

public interface ICitaService {
    void guardar(Cita cita);

    List<Cita> buscarTodas();
}

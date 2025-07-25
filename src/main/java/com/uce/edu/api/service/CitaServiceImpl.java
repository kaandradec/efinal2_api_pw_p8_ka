package com.uce.edu.api.service;

import java.util.List;

import com.uce.edu.api.repository.ICitaRepo;
import com.uce.edu.api.repository.model.Cita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CitaServiceImpl implements ICitaService {

    @Inject
    private ICitaRepo iCitaRepo;

    @Override
    public void guardar(Cita cita) {
        this.iCitaRepo.insertar(cita);
    }

    @Override
    public List<Cita> buscarTodas() {
        return this.iCitaRepo.seleccionarTodas();
    }

}

package com.uce.edu.api.service.mappers;

import com.uce.edu.api.repository.model.Cita;
import com.uce.edu.api.service.to.CitaCompletoTo;

public class CitaMapper {
    public static CitaCompletoTo toTo(Cita cita) {
        CitaCompletoTo citaCo = new CitaCompletoTo();

        citaCo.setNombrePaciente(cita.getPaciente().getNombre());
        citaCo.setApellidoPaciente(cita.getPaciente().getApellido());
        citaCo.setCedulaPaciente(cita.getPaciente().getCedula());
        citaCo.setFechaCita(cita.getFecha());
        citaCo.setNombreDoctor(cita.getDoctor().getNombre());

        return citaCo;

    }
}

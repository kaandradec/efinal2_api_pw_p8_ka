package com.uce.edu.api.service.mappers;

import com.uce.edu.api.repository.model.Paciente;
import com.uce.edu.api.service.to.PacienteTo;

public class PacienteMapper {
    public static Paciente toEntity(PacienteTo pacienteTo) {
        Paciente paciente = new Paciente();
        paciente.setCedula(pacienteTo.getCedula());
        paciente.setNombre(pacienteTo.getNombre());
        paciente.setApellido(pacienteTo.getApellido());
        paciente.setFechaNacimiento(pacienteTo.getFechaNacimiento());

        return paciente;
    }

}

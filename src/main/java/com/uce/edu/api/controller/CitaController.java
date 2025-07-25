package com.uce.edu.api.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.uce.edu.api.repository.model.Cita;
import com.uce.edu.api.repository.model.Doctor;
import com.uce.edu.api.repository.model.Paciente;
import com.uce.edu.api.service.ICitaService;
import com.uce.edu.api.service.IDoctorService;
import com.uce.edu.api.service.IPacienteService;
import com.uce.edu.api.service.mappers.CitaMapper;
import com.uce.edu.api.service.mappers.PacienteMapper;
import com.uce.edu.api.service.to.CitaCompletoTo;
import com.uce.edu.api.service.to.CitaTo;
import com.uce.edu.api.service.to.PacienteTo;

import io.vertx.codegen.annotations.GenIgnore;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/citas")
public class CitaController {

    @Inject
    private ICitaService iCitaService;

    @Inject
    private IDoctorService iDoctorService;

    @Inject
    private IPacienteService iPacienteService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodas() {

        try {
            List<Cita> citas = this.iCitaService.buscarTodas();

            List<CitaCompletoTo> citasCo = citas.stream().map(CitaMapper::toTo).collect(Collectors.toList());

            return Response.status(Response.Status.OK).entity(citasCo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody CitaTo citaTo) {

        try {
            Doctor doctor = this.iDoctorService.buscarPorCedula(citaTo.getCedulaDoctor());
            Paciente paciente = this.iPacienteService.buscarPorCedula(citaTo.getCedulaPaciente());

            Cita cita = new Cita();
            cita.setFecha(citaTo.getFecha());
            cita.setDoctor(doctor);
            cita.setPaciente(paciente);

            this.iCitaService.guardar(cita);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}

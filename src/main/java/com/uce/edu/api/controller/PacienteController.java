package com.uce.edu.api.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.uce.edu.api.repository.model.Paciente;
import com.uce.edu.api.service.IPacienteService;
import com.uce.edu.api.service.mappers.PacienteMapper;
import com.uce.edu.api.service.to.PacienteTo;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pacientes")
public class PacienteController {

    @Inject
    private IPacienteService iPacienteService;

    @GET
    @Path("/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorCedula(@PathParam("cedula") String cedula) {

        try {
            Paciente paciente = this.iPacienteService.buscarPorCedula(cedula);
            return Response.status(Response.Status.OK).entity(paciente).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody PacienteTo pacienteTo) {

        try {
            this.iPacienteService.guardar(PacienteMapper.toEntity(pacienteTo));
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}

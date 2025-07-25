package com.uce.edu.api.service.to;

public class CitaTo {
    private String cedulaDoctor;
    private String cedulaPaciente;
    private String fecha;

    public String getCedulaDoctor() {
        return cedulaDoctor;
    }

    public void setCedulaDoctor(String cedulaDoctor) {
        this.cedulaDoctor = cedulaDoctor;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}

package com.springBajo8.springBajo8.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

@Document(collection = "citas")
public class citasDTOReactiva {

    @Id
    private String  id = UUID.randomUUID().toString().substring(0, 10);

    private String idPaciente;

    private String nombrePaciente;

    private String apellidosPaciente;

    private String nombreMedico;

    private String apellidosMedico;

    private String fechaReservaCita;

    private String horaReservaCita;

    private String estadoReservaCita;

    private HashMap<String,String> historiaClinica;


  public citasDTOReactiva(String id, String idPaciente, String nombrePaciente, String apellidosPaciente, String nombreMedico, String apellidosMedico, String fechaReservaCita, String horaReservaCita, String estadoReservaCita, HashMap<String,String> historiaClinica) {
    this.id = id;
    this.idPaciente = idPaciente;
    this.nombrePaciente = nombrePaciente;
    this.apellidosPaciente = apellidosPaciente;
    this.nombreMedico = nombreMedico;
    this.apellidosMedico = apellidosMedico;
    this.fechaReservaCita = fechaReservaCita;
    this.horaReservaCita = horaReservaCita;
    this.estadoReservaCita = estadoReservaCita;
    this.historiaClinica = historiaClinica;
  }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        this.apellidosMedico = apellidosMedico;
    }

    public String getFechaReservaCita() {
        return fechaReservaCita;
    }

    public void setFechaReservaCita(String fechaReservaCita) {
        this.fechaReservaCita = fechaReservaCita;
    }

    public String getHoraReservaCita() {
        return horaReservaCita;
    }

    public void setHoraReservaCita(String horaReservaCita) {
        this.horaReservaCita = horaReservaCita;
    }

    public String getEstadoReservaCita() {
        return estadoReservaCita;
    }

    public void setEstadoReservaCita(String estadoReservaCita) {
        this.estadoReservaCita = estadoReservaCita;
    }

    public HashMap<String, String> gethistoriaClinica() {
      return historiaClinica;
    }

    public void sethistoriaClinica(HashMap<String,String> historiaClinica) {
        historiaClinica = historiaClinica;
    }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", idPaciente='" + getIdPaciente() + "'" +
      ", nombrePaciente='" + getNombrePaciente() + "'" +
      ", apellidosPaciente='" + getApellidosPaciente() + "'" +
      ", nombreMedico='" + getNombreMedico() + "'" +
      ", apellidosMedico='" + getApellidosMedico() + "'" +
      ", fechaReservaCita='" + getFechaReservaCita() + "'" +
      ", horaReservaCita='" + getHoraReservaCita() + "'" +
      ", estadoReservaCita='" + getEstadoReservaCita() + "'" +
      ", historiaClinica='" + gethistoriaClinica() + "'" +
      "}";
  }

}

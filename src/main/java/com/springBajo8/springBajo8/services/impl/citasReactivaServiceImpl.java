package com.springBajo8.springBajo8.services.impl;

import java.util.HashMap;

import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.repositories.IcitasReactivaRepository;
import com.springBajo8.springBajo8.services.IcitasReactivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
      return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Mono<citasDTOReactiva> findByFechaAndHora(String fechaReservaCita, String horaReservaCita) {
      return this.IcitasReactivaRepository.findByFechaReservaCitaAndHoraReservaCita(fechaReservaCita, horaReservaCita);
    }

    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }
    
    @Override
    public Mono<citasDTOReactiva> cancelarCita(String id) {
      return this.IcitasReactivaRepository.findById(id)
              .flatMap(citasDTOReactiva1 -> {
                  citasDTOReactiva1.setId(id);
                  citasDTOReactiva1.setEstadoReservaCita("Cancelado");
                  return save(citasDTOReactiva1);
              })
              .switchIfEmpty(Mono.empty());
    }

    //Agregar Padecimientos y tratamientos
    @Override
    public Flux<citasDTOReactiva> agregarHistoriaClinica(String IdPaciente,String padecimiento, String tratamiento){
      return IcitasReactivaRepository.findByIdPaciente(IdPaciente)
              .flatMap(citasDTOReactiva1 -> {
                  HashMap<String,String> historia = citasDTOReactiva1.getHistoriaClinica();
                  historia.put("ID", IdPaciente);
                  historia.put("Tratamiento",historia.get("Tratamiento") + "," + tratamiento);
                  historia.put("Padecimiento",historia.get("Padecimiento") + "," + tratamiento);
                  return save(citasDTOReactiva1);
              }).switchIfEmpty(Mono.empty());
      }

      
}

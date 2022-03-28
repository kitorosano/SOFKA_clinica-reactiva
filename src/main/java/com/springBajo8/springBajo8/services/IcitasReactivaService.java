package com.springBajo8.springBajo8.services;

import com.springBajo8.springBajo8.models.citasDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaService {
    Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> delete(String id);

    Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);
    
    Mono<citasDTOReactiva> findByFechaAndHora(String fechaReservaCita, String horaReservaCita);

    Flux<citasDTOReactiva> findAll();

    Mono<citasDTOReactiva> findById(String id);

    Mono<citasDTOReactiva> cancelarCita(String id);
    
    Flux<citasDTOReactiva> agregarHistoriaClinica(String IdPaciente, String padecimiento, String tratamiento);
}

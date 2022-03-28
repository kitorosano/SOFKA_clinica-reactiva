package com.springBajo8.springBajo8.services;

import java.time.LocalDate;
import java.util.List;
import com.springBajo8.springBajo8.models.PadecimientoTratamiento;
import com.springBajo8.springBajo8.models.citasDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaService {
  Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

  Mono<citasDTOReactiva> delete(String id);

  Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

  Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

  Flux<citasDTOReactiva> findAll();

  Mono<citasDTOReactiva> findById(String id);

  Flux<citasDTOReactiva> cancelarCita(String id);

  Flux<citasDTOReactiva> consultarFechaYHora(LocalDate fecha, String hora);

  Flux<citasDTOReactiva> consultarMedicoQueLoAtendera(String id);

  Flux<List<PadecimientoTratamiento>> consultarTratamientosYPadecimientos(String id);
}

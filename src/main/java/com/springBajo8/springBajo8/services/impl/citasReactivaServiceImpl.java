package com.springBajo8.springBajo8.services.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import com.springBajo8.springBajo8.models.PadecimientoTratamiento;

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
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Flux<citasDTOReactiva> cancelarCita(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva1.setEstadoReservaCita("Cancelado");
                    return save(citasDTOReactiva1);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> consultarFechaYHora(LocalDate fecha, String hora) {
        return this.IcitasReactivaRepository.findByFechaReservaCita(fecha)
                .filter(cita -> cita.getHoraReservaCita().equals(hora))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Flux<citasDTOReactiva> consultarMedicoQueLoAtendera(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(citasDTOReactiva1 -> {
                            citasDTOReactiva newCitaDTO = new citasDTOReactiva();
                            newCitaDTO.setNombreMedico(citasDTOReactiva1.getNombreMedico());
                            newCitaDTO.setApellidosMedico(citasDTOReactiva1.getApellidosMedico());
                            return Flux.just(newCitaDTO);
                        }
                )
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<List<PadecimientoTratamiento>> consultarTratamientosYPadecimientos(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(cita -> Mono.just(cita.getTratamientosList()))
                .switchIfEmpty(Mono.empty());
    }
      
}

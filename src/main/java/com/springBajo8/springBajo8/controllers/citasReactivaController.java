package com.springBajo8.springBajo8.controllers;

import java.time.LocalDate;
import java.util.List;

import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.services.IcitasReactivaService;
import com.springBajo8.springBajo8.models.PadecimientoTratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/citasReactiva")
public class citasReactivaController {

  @Autowired
  private IcitasReactivaService icitasReactivaService;
  
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
      return this.icitasReactivaService.save(citasDTOReactiva);
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
      return this.icitasReactivaService.delete(id)
              .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
              .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
      return this.icitasReactivaService.update(id, citasDTOReactiva)
              .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
              .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

  }

  @GetMapping("/{idPaciente}/byidPaciente")
  public Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
      return this.icitasReactivaService.findByIdPaciente(idPaciente);
  }

  @GetMapping(value = "")
  public Flux<citasDTOReactiva> findAll() {
      return this.icitasReactivaService.findAll();
  }

  @PutMapping("/cancelarCita/{idPaciente}/byidPaciente")
  public Flux<citasDTOReactiva> cancelarCitaByidPaciente(@PathVariable("idPaciente") String idPaciente) {
      return this.icitasReactivaService.cancelarCita(idPaciente);
  }

  @GetMapping("/consultarFechaHora/{fecha}/{hora}")
  public Flux<citasDTOReactiva> consultarFechaHora(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
      LocalDate fechaParseada = LocalDate.parse(fecha);
      return this.icitasReactivaService.consultarFechaYHora(fechaParseada, hora);
  }

  @GetMapping("/consultarMedico/{idPaciente}/byidPaciente")
  public Flux<citasDTOReactiva> consultarMedicoByIdPaciente(@PathVariable("idPaciente") String idPaciente) {
      return this.icitasReactivaService.consultarMedicoQueLoAtendera(idPaciente);
  }

  @GetMapping("/consultarTratamiento/{idPaciente}/byidPaciente")
  public Flux<List<PadecimientoTratamiento>> consultarTratamientoByIdPaciente(@PathVariable("idPaciente") String idPaciente) {
      return this.icitasReactivaService.consultarTratamientosYPadecimientos(idPaciente);
  }
}

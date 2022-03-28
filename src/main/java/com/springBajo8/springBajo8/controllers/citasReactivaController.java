package com.springBajo8.springBajo8.controllers;

import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.services.IcitasReactivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/citasReactiva")
public class citasReactivaController {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    // CREATION
    @PostMapping("")
    public Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        System.out.println(citasDTOReactiva);
        return this.icitasReactivaService.save(citasDTOReactiva);
    }
    
    //Agregar Padecimientos y tratamientos
    @PostMapping("/historia")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<citasDTOReactiva> agregarHistoriaClinica(String IdPaciente,String padecimiento, String tratamiento){
      return this.icitasReactivaService.agregarHistoriaClinica(IdPaciente, padecimiento, tratamiento);
    }
// ============================================
    
    // READING 
    @GetMapping("/paciente/{idPaciente}")
    public Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "")
    public Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }
    
    @GetMapping("/{fechaReserva}/{horaReserva}")
    public Mono<citasDTOReactiva> consultarFechaHora(@PathVariable("fechaReserva") String fechaReserva, @PathVariable("horaReserva") String horaReserva) {
        return this.icitasReactivaService.findByFechaAndHora(fechaReserva, horaReserva);
    }

    @GetMapping("/medico/{id}")
    public Mono<String> consultarMedicoConsulta(@PathVariable("id") String idPaciente){
        return this.icitasReactivaService.findById(idPaciente)
        .flatMap(citasDTOReactiva1 -> Mono.just(citasDTOReactiva1.getNombreMedico())).switchIfEmpty(Mono.empty());
    }

// ============================================
    // UPDATING
    @PutMapping("/{id}")
    public Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    // CancelarCita
    @PutMapping("/{id}/cancelar")
    public Mono<ResponseEntity<citasDTOReactiva>> cancelarCita(@PathVariable("id") String id) {
      return this.icitasReactivaService.cancelarCita(id)
              .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
              .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
    // ============================================

    // DELETION
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
    // ============================================
  
}

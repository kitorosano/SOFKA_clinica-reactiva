package com.springBajo8.springBajo8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.springBajo8.springBajo8.controllers.citasReactivaController;
import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.services.IcitasReactivaService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class citasReactivaControllerTest {
  @Autowired
  private IcitasReactivaService service;
 
  // @Test
  // @DisplayName("Get all citas empty")
  // void getAllCitasEmpty() {
  //   List<citasDTOReactiva> vacio = new ArrayList<>();
  //   Flux<citasDTOReactiva> citas = service.findAll();
  //   StepVerifier.create(citas).expectNext(vacio).verifyComplete();
  // }

  @Test
  @DisplayName("Add new cita")
  void postNewCita() {
    citasDTOReactiva cita = new citasDTOReactiva("1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada");
    Mono<citasDTOReactiva> citas = service.save(cita);
    StepVerifier.create(citas).expectNext(cita).verifyComplete();
  }


}

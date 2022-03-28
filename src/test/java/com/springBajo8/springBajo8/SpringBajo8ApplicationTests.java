package com.springBajo8.springBajo8;

import static org.mockito.Mockito.when;

import java.util.HashMap;

import com.springBajo8.springBajo8.controllers.citasReactivaController;
import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.repositories.IcitasReactivaRepository;
import com.springBajo8.springBajo8.services.IcitasReactivaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest
@ExtendWith(SpringExtension.class)
class SpringBajo8ApplicationTests {

    @Autowired
    private IcitasReactivaService servicio;

  // @Test
  // public void testGetCitas() {
  //   citasDTOReactiva cita1 = new citasDTOReactiva("1", "1","Paciente", "PacienteApellido","Medico","MedicoApellido","12-02-2022","23:59","Cancelado",new HashMap<>());
  //   citasDTOReactiva cita2 = new citasDTOReactiva("2", "1","Paciente", "PacienteApellido","Medico","MedicoApellido","14-03-2022","23:59","Reservado",new HashMap<>());
  //   Flux<citasDTOReactiva> citas=servicio.findAll();
    
  //   StepVerifier.create(citas).expectNext("Pedro").expectNext("Maria").expectNext("Jesus").expectNext("Carmen").verifyComplete();
  // }


}
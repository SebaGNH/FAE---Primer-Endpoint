package com.primerEndpoint.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/example")
@Scope("request")
public class DemoController {

    @GetMapping
    @Operation(summary ="retorna el iva de cada concepto de entrada enviado" ,
            responses= {
                    @ApiResponse(responseCode="200", description="el calculo se realizó correctamente"),
                    @ApiResponse(responseCode="400", description="petición incorrecta"),
                    @ApiResponse(responseCode="500", description="error interno del servicio")
            })
    public ResponseEntity<String> get(){
        return ResponseEntity
                .ok()
                .body("Hello World");
    }

    @GetMapping("/tareas")
    public ResponseEntity<String> getTareas() {
        return ResponseEntity
                .ok()
                .body("No hay tareas pendientes.");
    }

}
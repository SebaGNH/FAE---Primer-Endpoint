package com.primerEndpoint.demo.controller;

import com.primerEndpoint.demo.Globals;
import com.primerEndpoint.demo.dto.TareaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/example")
// @Scope("request")
public class DemoController {

        @GetMapping
        @Operation(summary = "retorna Saludo hola mundo", responses = {
                        @ApiResponse(responseCode = "200", description = "el calculo se realizó correctamente"),
                        @ApiResponse(responseCode = "400", description = "petición incorrecta"),
                        @ApiResponse(responseCode = "500", description = "error interno del servicio")
        })
        public ResponseEntity<String> get() {
                return ResponseEntity
                                .ok()
                                .body("Hello World");
        }





        @GetMapping("/tareas")
        @Operation(summary = "Get de tareas", responses = {
                @ApiResponse(responseCode = "200", description = "Obtiene la lista de tareas"),
                @ApiResponse(responseCode = "400", description = "petición incorrecta"),
                @ApiResponse(responseCode = "500", description = "error interno del servicio")
        })
        public ResponseEntity<List<TareaDTO>> getTareas() {
                return ResponseEntity
                        .ok()
                        .body(Globals.tareas);
        }





        @PostMapping("/tareas")
        
        public ResponseEntity<TareaDTO> postTarea(@RequestBody TareaDTO tarea) {
                Globals.tareas.add(tarea);
                return ResponseEntity
                        .ok()
                        .body(tarea);
        }





        @PutMapping("/tareas/{id}")
        public ResponseEntity<TareaDTO> putTarea(@PathVariable String id, @RequestBody TareaDTO tarea) {
                for (int i = 0; i < Globals.tareas.size(); i++) {
                        if (Globals.tareas.get(i).getId().equals(id)) {
                                Globals.tareas.set(i, tarea);
                                return ResponseEntity.ok().body(tarea);
                        }
                }
                return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/tareas/{id}")
        public ResponseEntity<Void> deleteTarea(@PathVariable String id) {
                for (int i = 0; i < Globals.tareas.size(); i++) {
                        if (Globals.tareas.get(i).getId().equals(id)) {
                                Globals.tareas.remove(i);
                                return ResponseEntity.ok().build();
                        }
                }
                return ResponseEntity.notFound().build();
        }

}

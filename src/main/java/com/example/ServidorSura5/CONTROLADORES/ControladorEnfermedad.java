package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.Enfermedad;
import com.example.ServidorSura5.SERVICIOS.ServicioEnfermedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enfermedad")
public class ControladorEnfermedad {
    @Autowired
    ServicioEnfermedad servicioEnfermedad;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Enfermedad datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioEnfermedad.guardarEnfermedad(datos));
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioEnfermedad.buscarEnfermedades());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEnfermedad(@PathVariable long id) {
        try {
            if (servicioEnfermedad.enfermedadExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioEnfermedad.buscarEnfermedad(id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado una enfermedad con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
        try {
            if (servicioEnfermedad.enfermedadExiste(id)) {
                servicioEnfermedad.eliminarEnfermedad(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Enfermedad eliminada Exitosamente");
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado la enfermedad con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Enfermedad datos, @PathVariable long id) {
        try {
            if (servicioEnfermedad.enfermedadExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioEnfermedad.editarEnfermedad(datos, id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado la enfermedad con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}

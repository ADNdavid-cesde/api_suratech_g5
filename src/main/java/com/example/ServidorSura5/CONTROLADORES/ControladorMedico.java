package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.Medico;
import com.example.ServidorSura5.SERVICIOS.ServicioMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medico")
public class ControladorMedico {
    @Autowired
    ServicioMedico servicioMedico;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medico datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioMedico.guardarMedico(datos));
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping //get = traer / obtener
    public ResponseEntity<?> obtenerTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioMedico.buscarMedicos());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMedico(@PathVariable long id) {
        try {
            if (servicioMedico.medicoExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioMedico.buscarMedico(id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medico con el id " + id);
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
            if (servicioMedico.medicoExiste(id)) {
                servicioMedico.eliminarMedico(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Medico eliminado Exitosamente");
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medico con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Medico datos, @PathVariable long id) {
        try {
            if (servicioMedico.medicoExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioMedico.editarMedico(datos, id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medico con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}

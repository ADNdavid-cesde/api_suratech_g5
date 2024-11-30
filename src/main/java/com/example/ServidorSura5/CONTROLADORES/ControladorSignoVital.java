package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.SignoVital;
import com.example.ServidorSura5.SERVICIOS.ServicioSignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signoVital")
public class ControladorSignoVital {
    @Autowired
    ServicioSignoVital servicioSignoVital;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody SignoVital datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioSignoVital.guardarSignoVital(datos));
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
                    .body(servicioSignoVital.buscarSignosVitales());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerSignoVital(@PathVariable long id) {
        try {
            if (servicioSignoVital.signoVitalExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioSignoVital.buscarSignoVital(id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el signo vital con el id " + id);
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
            if (servicioSignoVital.signoVitalExiste(id)) {
                servicioSignoVital.eliminarSignoVital(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Signo vital eliminado Exitosamente");
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el signo vital con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody SignoVital datos, @PathVariable long id) {
        try {
            if (servicioSignoVital.signoVitalExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioSignoVital.editarSignoVital(datos, id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el signo vital con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}
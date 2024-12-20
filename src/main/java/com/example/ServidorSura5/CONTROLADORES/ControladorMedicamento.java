package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.Medicamento;
import com.example.ServidorSura5.SERVICIOS.ServicioMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamento")
public class ControladorMedicamento {
    @Autowired
    ServicioMedicamento servicioMedicamento;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Medicamento datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioMedicamento.guardarMedicamento(datos));
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
                    .body(servicioMedicamento.buscarMedicamentos());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMedicamento(@PathVariable long id) {
        try {
            if (servicioMedicamento.medicamentoExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioMedicamento.buscarMedicamento(id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medicamento con el id " + id);
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
            if (servicioMedicamento.medicamentoExiste(id)) {
                servicioMedicamento.eliminarMedicamento(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Medicamento eliminado Exitosamente");
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medicamento con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Medicamento datos, @PathVariable long id) {
        try {
            if (servicioMedicamento.medicamentoExiste(id)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(servicioMedicamento.editarMedicamento(datos, id));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se ha encontrado el medicamento con el id " + id);
            }
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}

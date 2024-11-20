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
    public ResponseEntity<?> guardar(@RequestBody Medicamento datos){
        try{
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
    public ResponseEntity<?> obtener(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioMedicamento.buscarMedicamentos());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}

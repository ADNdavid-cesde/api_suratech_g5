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
    public ResponseEntity<?> guardar(@RequestBody Medico datos){
        try{
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
    public ResponseEntity<?> obtener(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioMedico.buscarMedicos());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }
}

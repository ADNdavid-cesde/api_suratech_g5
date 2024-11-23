package com.example.ServidorSura5.CONTROLADORES;

import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.SERVICIOS.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente") //yo decido como llamo el requestMapping
public class ControladorPaciente {
    @Autowired
    ServicioPaciente servicioPaciente;

    @PostMapping //post=guardar
    public ResponseEntity<?> guardar(@RequestBody Paciente datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioPaciente.guardarPaciente(datos));
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping //get = traer / obtener
    public ResponseEntity<?> obtenerTodos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioPaciente.buscarPacientes());
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> obtenerPaciente(@PathVariable long id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioPaciente.buscarPaciente( id ) );
        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage() );

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id){
        try{
            servicioPaciente.buscarPaciente(id);
            servicioPaciente.eliminarPaciente(id);
            return ResponseEntity.status(HttpStatus.OK);
        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage() );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Paciente datos, @PathVariable long id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioPaciente.guardarPaciente(datos) );
        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage() );
        }
    }*/
}

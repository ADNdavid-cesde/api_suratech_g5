package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPaciente {
    //1. Para activar al servicio: llamar al repositorio respectivo
    @Autowired
    IRepositorioPaciente iRepositorioPaciente;

    //2. Se programa las funciones para las distintas operaciones en la BD
    // función para guardar DATOS
    public Paciente guardarPaciente(Paciente datosPaciente) throws Exception{ //throws Exception:permite controlar las excepciones
        try {
          return iRepositorioPaciente.save(datosPaciente);
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    public List<Paciente> buscarPacientes() throws Exception{
        try {
            return iRepositorioPaciente.findAll();
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
    }
}
}

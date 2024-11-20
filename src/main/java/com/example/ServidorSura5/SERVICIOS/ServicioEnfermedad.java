package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Enfermedad;

import com.example.ServidorSura5.REPOSITORIOS.IRepositorioEnfermedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEnfermedad {
    @Autowired
    IRepositorioEnfermedad iRepositorioEnfermedad;

    public Enfermedad guardarEnfermedad(Enfermedad datosEnfermedad) throws Exception{
        try{
            return iRepositorioEnfermedad.save(datosEnfermedad);
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    public List<Enfermedad> buscarEnfermedades() throws Exception {
        try {
            return iRepositorioEnfermedad.findAll();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
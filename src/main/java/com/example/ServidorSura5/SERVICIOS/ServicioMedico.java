package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Medico;
import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMedico {
    @Autowired
    IRepositorioMedico iRepositorioMedico;

    public Medico guardarMedico(Medico datosMedico) throws Exception{
        try {
            return iRepositorioMedico.save(datosMedico);
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    public List<Medico> buscarMedicos() throws Exception {
        try {
            return iRepositorioMedico.findAll();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Enfermedad;
import com.example.ServidorSura5.MODELOS.Medicamento;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMedicamento {
    @Autowired
    IRepositorioMedicamento iRepositorioMedicamento ;

    public Medicamento guardarMedicamento(Medicamento datosMedicamento) throws Exception{
        try {
            return iRepositorioMedicamento.save(datosMedicamento);
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    public List<Medicamento> buscarMedicamentos() throws Exception {
        try {
            return iRepositorioMedicamento.findAll();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

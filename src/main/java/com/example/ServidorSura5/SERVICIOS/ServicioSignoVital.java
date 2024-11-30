package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.SignoVital;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioSignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioSignoVital {
    @Autowired
    IRepositorioSignoVital iRepositorioSignoVital;

    public SignoVital guardarSignoVital(SignoVital datosSignoVital) throws Exception {
        try {
            return iRepositorioSignoVital.save(datosSignoVital);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public List<SignoVital> buscarSignosVitales() throws Exception {
        try {
            return iRepositorioSignoVital.findAll();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<SignoVital> buscarSignoVital(long id) throws Exception {
        try {
            return iRepositorioSignoVital.findById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void eliminarSignoVital(long id) throws Exception {
        try {
            iRepositorioSignoVital.deleteById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<SignoVital> editarSignoVital(SignoVital datosSignoVital, long id) throws Exception {
        try {
            return iRepositorioSignoVital.findById(id)
                    .map(signoVital -> {
                        signoVital.setNombre(datosSignoVital.getNombre());
                        signoVital.setValor(datosSignoVital.getValor());
                        signoVital.setFechaMedida(datosSignoVital.getFechaMedida());
                        return iRepositorioSignoVital.save(signoVital);
                    });
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Boolean signoVitalExiste(long id) throws Exception {
        try {
            return iRepositorioSignoVital.existsById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Enfermedad;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioEnfermedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEnfermedad {
    @Autowired
    IRepositorioEnfermedad iRepositorioEnfermedad;

    public Enfermedad guardarEnfermedad(Enfermedad datosEnfermedad) throws Exception {
        try {
            return iRepositorioEnfermedad.save(datosEnfermedad);
        } catch (Exception exception) {
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

    public Optional<Enfermedad> buscarEnfermedad(long id) throws Exception {
        try {
            return iRepositorioEnfermedad.findById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void eliminarEnfermedad(long id) throws Exception {
        try {
            iRepositorioEnfermedad.deleteById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<Enfermedad> editarEnfermedad(Enfermedad datosEnfermedad, long id) throws Exception {
        try {
            return iRepositorioEnfermedad.findById(id)
                    .map(enfermedad -> {
                        enfermedad.setNombre(datosEnfermedad.getNombre());
                        enfermedad.setSintomas(datosEnfermedad.getSintomas());
                        enfermedad.setClasificacion(datosEnfermedad.getClasificacion());
                        enfermedad.setGrado(datosEnfermedad.getGrado());
                        enfermedad.setProbabilidadVida(datosEnfermedad.getProbabilidadVida());
                        return iRepositorioEnfermedad.save(enfermedad);
                    });
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Boolean enfermedadExiste(long id) throws Exception {
        try {
            return iRepositorioEnfermedad.existsById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

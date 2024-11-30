package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Medico;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMedico {
    @Autowired
    IRepositorioMedico iRepositorioMedico;

    public Medico guardarMedico(Medico datosMedico) throws Exception {
        try {
            return iRepositorioMedico.save(datosMedico);
        } catch (Exception exception) {
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

    public Optional<Medico> buscarMedico(long id) throws Exception {
        try {
            return iRepositorioMedico.findById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void eliminarMedico(long id) throws Exception {
        try {
            iRepositorioMedico.deleteById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<Medico> editarMedico(Medico datosMedico, long id) throws Exception {
        try {
            return iRepositorioMedico.findById(id)
                    .map(medico -> {
                        medico.setNombre(datosMedico.getNombre());
                        medico.setMatriculaProfesional(datosMedico.getMatriculaProfesional());
                        medico.setEspecialidad(datosMedico.getEspecialidad());
                        medico.setSalario(datosMedico.getSalario());
                        medico.setIps(datosMedico.getIps());
                        medico.setCorreo(datosMedico.getCorreo());
                        medico.setTelefono(datosMedico.getTelefono());
                        medico.setDireccionConsultorio(datosMedico.getDireccionConsultorio());
                        medico.setFinDeSemanaDisponible(datosMedico.getFinDeSemanaDisponible());
                        return iRepositorioMedico.save(medico);
                    });
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Boolean medicoExiste(long id) throws Exception {
        try {
            return iRepositorioMedico.existsById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

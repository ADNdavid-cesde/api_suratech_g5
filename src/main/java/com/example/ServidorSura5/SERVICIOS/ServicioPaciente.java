package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Paciente;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPaciente {
    //1. Para activar al servicio: llamar al repositorio respectivo
    @Autowired
    IRepositorioPaciente iRepositorioPaciente;

    //2. Se programa las funciones para las distintas operaciones en la BD
    // función para guardar DATOS
    public Paciente guardarPaciente(Paciente datosPaciente) throws Exception { //throws Exception:permite controlar las excepciones
        try {
            return iRepositorioPaciente.save(datosPaciente);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public List<Paciente> buscarPacientes() throws Exception {
        try {
            return iRepositorioPaciente.findAll();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<Paciente> buscarPaciente(long id) throws Exception {
        try {
            return iRepositorioPaciente.findById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void eliminarPaciente(long id) throws Exception {
        try {
            iRepositorioPaciente.deleteById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<Paciente> editarPaciente(Paciente datosPaciente, long id) throws Exception {
        try {
            return iRepositorioPaciente.findById(id)
                    .map(paciente -> {
                        paciente.setNombre(datosPaciente.getNombre());
                        paciente.setAnioNacimiento(datosPaciente.getAnioNacimiento());
                        paciente.setCiudad(datosPaciente.getCiudad());
                        paciente.setCorreo(datosPaciente.getCorreo());
                        paciente.setTelefono(datosPaciente.getTelefono());
                        paciente.setIps(datosPaciente.getIps());
                        paciente.setPoliza(datosPaciente.getPoliza());
                        paciente.setGrupoIngresos(datosPaciente.getGrupoIngresos());
                        paciente.setFechaAfiliacion(datosPaciente.getFechaAfiliacion());

                        return iRepositorioPaciente.save(paciente);
                    });
                    /*.orElseGet(() -> {
                        return iRepositorioPaciente.save(datosPaciente);
                    });*/
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Boolean pacienteExiste(long id) throws Exception {
        try {
            return iRepositorioPaciente.existsById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

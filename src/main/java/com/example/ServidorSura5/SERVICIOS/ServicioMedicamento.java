package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.Medicamento;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMedicamento {
    @Autowired
    IRepositorioMedicamento iRepositorioMedicamento;

    public Medicamento guardarMedicamento(Medicamento datosMedicamento) throws Exception {
        try {
            return iRepositorioMedicamento.save(datosMedicamento);
        } catch (Exception exception) {
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

    public Optional<Medicamento> buscarMedicamento(long id) throws Exception {
        try {
            return iRepositorioMedicamento.findById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void eliminarMedicamento(long id) throws Exception {
        try {
            iRepositorioMedicamento.deleteById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Optional<Medicamento> editarMedicamento(Medicamento datosMedicamento, long id) throws Exception {
        try {
            return iRepositorioMedicamento.findById(id)
                    .map(medicamento -> {
                        medicamento.setNombre(datosMedicamento.getNombre());
                        medicamento.setPresentacion(datosMedicamento.getPresentacion());
                        medicamento.setDosis(datosMedicamento.getDosis());
                        medicamento.setLaboratorio(datosMedicamento.getLaboratorio());
                        medicamento.setFechaCaducidad(datosMedicamento.getFechaCaducidad());
                        medicamento.setContraIndicaciones(datosMedicamento.getContraIndicaciones());
                        medicamento.setRegistroInvima(datosMedicamento.getRegistroInvima());
                        medicamento.setCopago(datosMedicamento.getCopago());
                        return iRepositorioMedicamento.save(medicamento);
                    });
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Boolean medicamentoExiste(long id) throws Exception {
        try {
            return iRepositorioMedicamento.existsById(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

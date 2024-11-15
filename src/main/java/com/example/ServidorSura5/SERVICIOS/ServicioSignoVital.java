package com.example.ServidorSura5.SERVICIOS;

import com.example.ServidorSura5.MODELOS.SignoVital;
import com.example.ServidorSura5.REPOSITORIOS.IRepositorioSignoVital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioSignoVital {
    @Autowired
    IRepositorioSignoVital iRepositorioSignoVital ;

    public SignoVital guardarSignoVital(SignoVital datosSignoVital) throws Exception{
        try {
            return iRepositorioSignoVital.save(datosSignoVital);
        }catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }
}

package com.example.ServidorSura5.HELPERS;

import com.example.ServidorSura5.MODELOS.Paciente;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*public class ValidacionPaciente {

    //1. Inyectar un objeto de la clase MODELO
    //inyectar=traer una clase y usarla dentro de otra
    private Paciente paciente= new Paciente();

    //2. Creamos un metodo para cada campo que quiero validar
    public boolean validarNombres(String nombres){
        //1. Se consulta una expresion regular
        //almacenandola en una variable de tipo string
        String expresionRegular="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$ ";

        //2. Activar el patron
        Pattern patron=Pattern.compile(expresionRegular);

        //3. Se busca coincidencia entre la cadena y el patron
        Matcher coincidencia= patron.matcher(nombres);

        //4. Indico si hubo o no hubo coincidencia
        if(coincidencia.find()){
            return true;
        }else{
            return false;
        }
    }
    public boolean validarFechaNacimiento(LocalDate fecha){}

    public boolean validarCiudad(String ciudad){
        //1. Se consulta una expresion regular
        //almacenandola en una variable de tipo string
        String expresionRegular="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$ ";

        //2. Activar el patron
        Pattern patron=Pattern.compile(expresionRegular);

        //3. Se busca coincidencia entre la cadena y el patron
        Matcher coincidencia= patron.matcher(ciudad);

        //4. Indico si hubo o no hubo coincidencia
        if(coincidencia.find()){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarCorreo(String correo){

    }

    public boolean validarTelefono(String telefono){}

    public boolean validarIps(String Ips){}

    public boolean validarGrupoIngreso(String grupoIngreso){}

    public boolean validarFechaAfiliacion(LocalDate fechaAfiliacion){}

}

*/


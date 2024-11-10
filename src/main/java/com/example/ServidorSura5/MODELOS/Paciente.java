package com.example.ServidorSura5.MODELOS;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity //anotación, palabra reservada
@Table(name="pacientes")

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre; //35 caracteres y solo letras
    private LocalDate anioNacimiento; //maximo 1900
    private String ciudad; //40 caracteres y solo letras
    private String correo; //correo valido @sura.com.co
    private String telefono; //maximo 12 caracteres y solo numeros
    private String ips; //maximo 50 caracteres
    private Boolean poliza;
    private String grupoIngresos; //SOLO SE ADMITE A, B O C en mayuscula
    private LocalDate fechaAfiliacion; //no puede ser menor a 2010


    //Creando una relacion con la clase Medico
    //Me relaciono con 1 medico
    @ManyToOne
    @JoinColumn(name = "fk_medico", referencedColumnName = "id")
    @JsonBackReference
    private Medico medico;

    @OneToMany(mappedBy = "paciente")
    @JsonManagedReference
    private List<SignoVital> signosVitales;

    public Paciente()
    {
    }

    public Paciente(long id, String nombre, LocalDate anioNacimiento, String ciudad, String correo, String telefono, String ips, Boolean poliza, String grupoIngresos, LocalDate fechaAfiliacion) {
        this.id = id;
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.ciudad = ciudad;
        this.correo = correo;
        this.telefono = telefono;
        this.ips = ips;
        this.poliza = poliza;
        this.grupoIngresos = grupoIngresos;
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(LocalDate anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public Boolean getPoliza() {
        return poliza;
    }

    public void setPoliza(Boolean poliza) {
        this.poliza = poliza;
    }

    public String getGrupoIngresos() {
        return grupoIngresos;
    }

    public void setGrupoIngresos(String grupoIngresos) {
        this.grupoIngresos = grupoIngresos;
    }

    public LocalDate getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(LocalDate fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }
}

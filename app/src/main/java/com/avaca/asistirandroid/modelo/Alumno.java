package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Alumno implements Serializable {
    public int Id;
    public String Nombre ;
    public String Apellido ;
    public String DNI ;
    public String Celular ;
    public boolean Activo ;

    public Alumno(int id, String nombre, String apellido, String DNI, String celular, boolean activo) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        this.DNI = DNI;
        Celular = celular;
        Activo = activo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

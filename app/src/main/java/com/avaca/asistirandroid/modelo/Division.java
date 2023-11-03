package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Division implements Serializable {
    public int Id ;
    public String Nombre;

    public Division(int id, String nombre) {
        Id = id;
        Nombre = nombre;
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

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

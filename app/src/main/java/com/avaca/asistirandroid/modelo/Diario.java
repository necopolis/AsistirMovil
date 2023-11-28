package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Diario implements Serializable {
    public int Id ;
    public String Fecha ;
    public String Resumen ;
    public int AutoridadId ;

    public Diario(int id, String fecha, String resumen, int autoridadId) {
        Id = id;
        Fecha = fecha;
        Resumen = resumen;
        AutoridadId = autoridadId;
    }

    public Diario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    public int getAutoridadId() {
        return AutoridadId;
    }

    public void setAutoridadId(int autoridadId) {
        AutoridadId = autoridadId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

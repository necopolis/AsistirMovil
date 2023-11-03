package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Diario implements Serializable {
    public int Id ;
    public Date Fecha ;
    public String Resumen ;
    public int AutoridadId ;
    public Autoridad Autoridad ;

    public Diario(int id, Date fecha, String resumen, int autoridadId, com.avaca.asistirandroid.modelo.Autoridad autoridad) {
        Id = id;
        Fecha = fecha;
        Resumen = resumen;
        AutoridadId = autoridadId;
        Autoridad = autoridad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
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

    public com.avaca.asistirandroid.modelo.Autoridad getAutoridad() {
        return Autoridad;
    }

    public void setAutoridad(com.avaca.asistirandroid.modelo.Autoridad autoridad) {
        Autoridad = autoridad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

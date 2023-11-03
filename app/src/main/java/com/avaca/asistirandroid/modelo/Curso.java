package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Curso implements Serializable {
    public int Id ;
    public int AnoId ;
    public int DivisionId;
    public int TurnoId;
    public Date AnoFecha ;
    public int AutoridadId ;
    public Autoridad Autoridad ;
    public Ano Ano;
    public Division Division ;
    public Turno Turno ;

    public Curso(int id, int anoId, int divisionId, int turnoId, Date anoFecha, int autoridadId, com.avaca.asistirandroid.modelo.Autoridad autoridad, com.avaca.asistirandroid.modelo.Ano ano, com.avaca.asistirandroid.modelo.Division division, Turno turno) {
        Id = id;
        AnoId = anoId;
        DivisionId = divisionId;
        TurnoId = turnoId;
        AnoFecha = anoFecha;
        AutoridadId = autoridadId;
        Autoridad = autoridad;
        Ano = ano;
        Division = division;
        Turno = turno;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAnoId() {
        return AnoId;
    }

    public void setAnoId(int anoId) {
        AnoId = anoId;
    }

    public int getDivisionId() {
        return DivisionId;
    }

    public void setDivisionId(int divisionId) {
        DivisionId = divisionId;
    }

    public int getTurnoId() {
        return TurnoId;
    }

    public void setTurnoId(int turnoId) {
        TurnoId = turnoId;
    }

    public Date getAnoFecha() {
        return AnoFecha;
    }

    public void setAnoFecha(Date anoFecha) {
        AnoFecha = anoFecha;
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

    public com.avaca.asistirandroid.modelo.Ano getAno() {
        return Ano;
    }

    public void setAno(com.avaca.asistirandroid.modelo.Ano ano) {
        Ano = ano;
    }

    public com.avaca.asistirandroid.modelo.Division getDivision() {
        return Division;
    }

    public void setDivision(com.avaca.asistirandroid.modelo.Division division) {
        Division = division;
    }

    public Turno getTurno() {
        return Turno;
    }

    public void setTurno(Turno turno) {
        Turno = turno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

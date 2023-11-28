package com.avaca.asistirandroid.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Curso implements Serializable {
//    @SerializedName("Id")
//    public int Id ;
//
//    @SerializedName("TurnoId")
//    public int TurnoId;
//
//    @SerializedName("AnoId")
//    public int AnoId ;
//
//    @SerializedName("DivisionId")
//    public int DivisionId;
//
//    @SerializedName("AnoFecha")
//    public Date AnoFecha ;
//
//    @SerializedName("AutoridadId")
//    public int AutoridadId ;
//
////    @SerializedName("Autoridad")
////    public Autoridad Autoridad= new Autoridad();
//
//    @SerializedName("TurnoNombre")
//    public String TurnoNombre;
//
//    @SerializedName("AnoNombre")
//    public String AnoNombre;
//
//    @SerializedName("DivisionNombre")
//    public String DivisionNombre;


    public Curso(int id, int turnoId, String turnoNombre, int anoId, String anoNombre, int divisionId, String divisionNombre, String anoFecha, int autoridadId, Autoridad autoridad) {
        this.Id = id;
        this.turnoId = turnoId;
        this.turnoNombre = turnoNombre;
        this.anoId = anoId;
        this.anoNombre = anoNombre;
        this.divisionId = divisionId;
        this.divisionNombre = divisionNombre;
        this.anoFecha = anoFecha;
        this.autoridadId = autoridadId;
        this.autoridad = autoridad;
    }

    public Curso() {
    }

    @SerializedName("Id")
    private int Id;

    @SerializedName("TurnoId")
    private int turnoId;

    @SerializedName("TurnoNombre")
    private String turnoNombre;

    @SerializedName("AnoId")
    private int anoId;

    @SerializedName("AnoNombre")
    private String anoNombre;

    @SerializedName("DivisionId")
    private int divisionId;

    @SerializedName("DivisionNombre")
    private String divisionNombre;

    @SerializedName("AnoFecha")
    private String anoFecha;

    @SerializedName("AutoridadId")
    private int autoridadId;

    @SerializedName("Autoridad")
    private Autoridad autoridad;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }

    public String getTurnoNombre() {
        return turnoNombre;
    }

    public void setTurnoNombre(String turnoNombre) {
        this.turnoNombre = turnoNombre;
    }

    public int getAnoId() {
        return anoId;
    }

    public void setAnoId(int anoId) {
        this.anoId = anoId;
    }

    public String getAnoNombre() {
        return anoNombre;
    }

    public void setAnoNombre(String anoNombre) {
        this.anoNombre = anoNombre;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionNombre() {
        return divisionNombre;
    }

    public void setDivisionNombre(String divisionNombre) {
        this.divisionNombre = divisionNombre;
    }

    public String getAnoFecha() {
        return anoFecha;
    }

    public void setAnoFecha(String anoFecha) {
        this.anoFecha = anoFecha;
    }

    public int getAutoridadId() {
        return autoridadId;
    }

    public void setAutoridadId(int autoridadId) {
        this.autoridadId = autoridadId;
    }

    public Autoridad getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(Autoridad autoridad) {
        this.autoridad = autoridad;
    }
//    public Curso(int id, int anoId, int divisionId, int turnoId, Date anoFecha, int autoridadId, Autoridad autoridad, Ano ano, Division division, Turno turno) {
//        Id = id;
//        AnoId = anoId;
//        DivisionId = divisionId;
//        TurnoId = turnoId;
//        AnoFecha = anoFecha;
//        AutoridadId = autoridadId;
//        Autoridad = autoridad;
//        Ano = ano;
//        Division = division;
//        Turno = turno;
//    }
//    public Curso(int id, int anoId, int divisionId, int turnoId, Date anoFecha, int autoridadId) {
//        Id = id;
//        AnoId = anoId;
//        DivisionId = divisionId;
//        TurnoId = turnoId;
//        AnoFecha = anoFecha;
//        AutoridadId = autoridadId;
//    }
//    public Curso(int id, int anoId, int divisionId, int turnoId, Date anoFecha) {
//        Id = id;
//        AnoId = anoId;
//        DivisionId = divisionId;
//        TurnoId = turnoId;
//        AnoFecha = anoFecha;
//    }
//
//    public Curso() {
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public int getAnoId() {
//        return AnoId;
//    }
//
//    public void setAnoId(int anoId) {
//        AnoId = anoId;
//    }
//
//    public int getDivisionId() {
//        return DivisionId;
//    }
//
//    public void setDivisionId(int divisionId) {
//        DivisionId = divisionId;
//    }
//
//    public int getTurnoId() {
//        return TurnoId;
//    }
//
//    public void setTurnoId(int turnoId) {
//        TurnoId = turnoId;
//    }
//
//    public Date getAnoFecha() {
//        return AnoFecha;
//    }
//
//    public void setAnoFecha(Date anoFecha) {
//        AnoFecha = anoFecha;
//    }
//
//    public int getAutoridadId() {
//        return AutoridadId;
//    }
//
//    public void setAutoridadId(int autoridadId) {
//        AutoridadId = autoridadId;
//    }
//
//    public String getTurnoNombre() {
//        return TurnoNombre;
//    }
//
//    public void setTurnoNombre(String turnoNombre) {
//        TurnoNombre = turnoNombre;
//    }
//
//    public String getAnoNombre() {
//        return AnoNombre;
//    }
//
//    public void setAnoNombre(String anoNombre) {
//        AnoNombre = anoNombre;
//    }
//
//    public String getDivisionNombre() {
//        return DivisionNombre;
//    }
//
//    public void setDivisionNombre(String divisionNombre) {
//        DivisionNombre = divisionNombre;
//    }
//



//    public com.avaca.asistirandroid.modelo.Autoridad getAutoridad() {
//        return Autoridad;
//    }
//
//    public void setAutoridad(com.avaca.asistirandroid.modelo.Autoridad autoridad) {
//        Autoridad = autoridad;
//    }

//    public com.avaca.asistirandroid.modelo.Ano getAno() {
//        return Ano;
//    }
//
//    public void setAno(com.avaca.asistirandroid.modelo.Ano ano) {
//        Ano = ano;
//    }
//
//    public com.avaca.asistirandroid.modelo.Division getDivision() {
//        return Division;
//    }
//
//    public void setDivision(com.avaca.asistirandroid.modelo.Division division) {
//        Division = division;
//    }
//
//    public Turno getTurno() {
//        return Turno;
//    }
//
//    public void setTurno(Turno turno) {
//        Turno = turno;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

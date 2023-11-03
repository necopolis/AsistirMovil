package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Cuaderno implements Serializable {
    public int Id ;
    public int AlumnoId ;
    public Alumno Alumno ;
    public String Mensaje ;

    public Cuaderno(int id, int alumnoId, com.avaca.asistirandroid.modelo.Alumno alumno, String mensaje) {
        Id = id;
        AlumnoId = alumnoId;
        Alumno = alumno;
        Mensaje = mensaje;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAlumnoId() {
        return AlumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        AlumnoId = alumnoId;
    }

    public com.avaca.asistirandroid.modelo.Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(com.avaca.asistirandroid.modelo.Alumno alumno) {
        Alumno = alumno;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

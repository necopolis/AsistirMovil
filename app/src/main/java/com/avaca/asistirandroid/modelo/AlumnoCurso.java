package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class AlumnoCurso implements Serializable {
    public int Id ;
    public boolean Estado ;
    public int AlumnoId ;
    public Alumno Alumno ;
    public int CursoId ;
    public Curso Curso ;

    public AlumnoCurso(int id, boolean estado, int alumnoId, com.avaca.asistirandroid.modelo.Alumno alumno, int cursoId, Curso curso) {
        Id = id;
        Estado = estado;
        AlumnoId = alumnoId;
        Alumno = alumno;
        CursoId = cursoId;
        Curso = curso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
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

    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int cursoId) {
        CursoId = cursoId;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso curso) {
        Curso = curso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

package com.avaca.asistirandroid.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Autoridad implements Serializable{
    public int Id;
    public String Nombre ;
    public String Apellido ;
    public String DNI ;
    public String Contraseña ;
//    public int TurnoId ;
//    public Turno Turno;
//    public int RolId ;
//    public Rol Rol;

    public Autoridad() {
    }

//    public Autoridad(int id, String nombre, String apellido, String DNI, String contraseña, int turnoId, Turno turno, int rolId, Rol rol) {
//        this.Id = id;
//        this.Nombre = nombre;
//        this.Apellido = apellido;
//        this.DNI = DNI;
//        this.Contraseña = contraseña;
//        this.TurnoId = turnoId;
//        this.Turno = turno;
//        this.RolId = rolId;
//        this.Rol = rol;
//    }

    public Autoridad(int id, String nombre, String apellido, String DNI, String contraseña) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.DNI = DNI;
        this.Contraseña = contraseña;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

//    public int getTurnoId() {
//        return TurnoId;
//    }
//
//    public void setTurnoId(int turnoId) {
//        TurnoId = turnoId;
//    }

//    public Turno getTurno() {
//        return Turno;
//    }
//
//    public void setTurno(Turno turno) {
//        Turno = turno;
//    }
//
//    public int getRolId() {
//        return RolId;
//    }
//
//    public void setRolId(int rolId) {
//        RolId = rolId;
//    }
//
//    public Rol getRol() {
//        return Rol;
//    }
//
//    public void setRol(Rol rol) {
//        Rol = rol;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

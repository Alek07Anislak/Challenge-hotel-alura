package com.hotel.jdbc.modelo;

import java.sql.Date;

public class Huespedes {
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String celular;
    private Integer idReserva;

  
    public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
    }

    public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,String celular, Integer idReserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.idReserva=idReserva;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdReservas() {
        return this.idReserva;
    }

    public void setIdReservas(Integer idReserva) {
        this.idReserva = idReserva;
    }


    // @Override
    // public String toString() {
    //     return String.format("{id: %s, nombre: %s, descripcion: %s, cantidad: %d}", this.id, this.nombre, this.descripcion,this.cantidad);
    //     //%s es de String  y %d es porque es un valor numérico
    // }

    
    
}

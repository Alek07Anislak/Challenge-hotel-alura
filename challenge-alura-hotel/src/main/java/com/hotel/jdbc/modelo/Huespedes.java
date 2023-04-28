package com.hotel.jdbc.modelo;

import java.sql.Date;

public class Huespedes {
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private Integer celular;
    private Integer idReserva;

  
    public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, Integer celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
    }

    public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
    Integer celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
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

    public Integer getCelular() {
        return celular;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoriaId() {
        return this.idReserva;
    }

    public void setCategoriaId(Integer idReserva) {
        this.idReserva = idReserva;
    }


    // @Override
    // public String toString() {
    //     return String.format("{id: %s, nombre: %s, descripcion: %s, cantidad: %d}", this.id, this.nombre, this.descripcion,this.cantidad);
    //     //%s es de String  y %d es porque es un valor numérico
    // }

    
    
}

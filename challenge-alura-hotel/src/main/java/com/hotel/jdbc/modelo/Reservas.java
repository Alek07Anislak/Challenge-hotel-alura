package com.hotel.jdbc.modelo;

import java.sql.Date;

public class Reservas {
    private Integer id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Double valor;
    private String formaPago;


    public Reservas(Integer id, Date fechaEntrada, Date fechaSalida, Double valor, String formaPago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }


    public Integer getId() {
        return id;
    }

    
    
    
}

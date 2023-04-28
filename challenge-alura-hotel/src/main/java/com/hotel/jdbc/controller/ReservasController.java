package com.hotel.jdbc.controller;

import java.util.List;

import com.hotel.jdbc.dao.ReservasDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Reservas;

public class ReservasController {
    private ReservasDAO reservasDAO;

    public ReservasController() {
        this.reservasDAO = new ReservasDAO(new ConnectionFactory().recuperaConexion());//INICIALIZANDO reservasDAO
    }

    public List<Reservas> listar() {
        return reservasDAO.listar();
    }

    
}

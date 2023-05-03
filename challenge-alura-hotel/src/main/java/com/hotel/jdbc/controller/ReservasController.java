package com.hotel.jdbc.controller;

import java.sql.Date;//IMPORTANTE TOMAR EN CUENTA QUE SEA DE SQL PARA BASE DE DATOS
import java.util.List;

import com.hotel.jdbc.dao.ReservasDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Reservas;

public class ReservasController {// CLASE INTERMEDIARIA ENTRE  NUESTRA CLASE "ReservasDAO"  Y NUESTRA VIEWS (VISTA DE LA APLICACIÓN)
    private ReservasDAO reservasDAO;

    public ReservasController() {
        this.reservasDAO = new ReservasDAO(new ConnectionFactory().recuperaConexion());//INICIALIZANDO reservasDAO
    }


    /**
     * MODIFICAR**************************************************************************************************************
     */
    public Integer modificar(Integer id, Date fechaEntrada, Date fechaSalida, Double valor, String tipoPago) {
        return this.reservasDAO.modificar(id, fechaEntrada,fechaSalida,valor,tipoPago);
    }

    /**
     * ELIMINAR***************************************************************************************************************
     */
    public Integer eliminar(Integer id) {
        return this.reservasDAO.eliminar(id);
    }

    /**
     * GUARDAR***************************************************************************************************************** 
     */
    public void guardar(Reservas reservas) {
        //reservas.setId(id);
         this.reservasDAO.guardar(reservas);
        
    }

    /**
     * LISTAR********************************************************************************************************************
     */
    public List<Reservas> listar() {//BUSCAR
        return this.reservasDAO.listar();
    }



    
}

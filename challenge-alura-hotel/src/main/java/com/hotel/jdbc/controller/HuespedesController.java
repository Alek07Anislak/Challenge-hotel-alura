package com.hotel.jdbc.controller;

import java.sql.Date;
import java.util.List;

import com.hotel.jdbc.dao.HuespedesDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Huespedes;

public class HuespedesController {//REALIZA LA CONEXIÓN ENTRE LA VIEW Y LA FUENTE DE DATOS QUE CONTIENE EL MODELO
    private HuespedesDAO huespedesDAO;

    public HuespedesController() {
        this.huespedesDAO = new HuespedesDAO(new ConnectionFactory().recuperaConexion());
    }

    /**
     * MODIFICAR**************************************************************************************************************
     */
    public Integer modificar(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, Integer celular) {
        return huespedesDAO.modificar(id, nombre, apellido, fechaNacimiento, nacionalidad, celular);
    }

    /**
     * ELIMINAR***************************************************************************************************************
     */
    public Integer eliminar(Integer id) {
        return huespedesDAO.eliminar(id);
    }

    /**
     * GUARDAR***************************************************************************************************************** 
     */
    public void guardar(Huespedes huespedes , Integer idReservas) {
         huespedes.setIdReservas(idReservas);
         huespedesDAO.guardar(huespedes);
    }

    /**
     * LISTAR*****************************************************************************************************************
     */
    public List<Huespedes> listar() { //BUSCAR
        return huespedesDAO.listar();
    }
}

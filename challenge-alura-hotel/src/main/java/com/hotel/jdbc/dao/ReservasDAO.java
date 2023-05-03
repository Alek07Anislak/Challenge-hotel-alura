package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hotel.jdbc.modelo.Reservas;

public class ReservasDAO { //Clase que hace de puente entre nuestra aplicación y nuestra base de datos. En esta clase existen todos los Métodos que representan todas las operaciones del CRUD
    final private Connection con;

    public ReservasDAO(Connection con) { //CONSTRUCTOR
        this.con = con;
        //this.con= new ConnectionFactory().recuperaConexion();
    }

    /**
     *GUARDA*****************************************************************************************************************************
     */
    public void guardar(Reservas reservas) {
        try(con) {
            final PreparedStatement stmt = con.prepareStatement("INSERT INTO reservas (Fecha_Entrada,Fecha_Salida,Valor,Forma_Pago) "+
                                                                    "VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    try(stmt) {
                            
                        ejecutarRegistro(reservas, stmt);
                    
                    }
    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  
    }

    private void ejecutarRegistro(Reservas reservas, PreparedStatement stmt) throws SQLException{
    
        stmt.setDate(1,reservas.getFechaEntrada());
        stmt.setDate(2,reservas.getFechaSalida());
        stmt.setDouble(3,reservas.getValor());
        stmt.setString(4,reservas.getFormaPago());
       
    
        stmt.execute();
    
        final ResultSet resultSet = stmt.getGeneratedKeys(); //Tomamos la ID generada
    
        try(resultSet) {
            
            while (resultSet.next()) {
                reservas.setId(resultSet.getInt(1));
    
            }
    
        }
        
    }
    /**
 * ELIMINAR****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
 */
public int eliminar(Integer id) {
    try {
        final PreparedStatement stmt=con.prepareStatement("DELETE FROM reservas WHERE ID=?");
        try(stmt){
             stmt.setInt(1,id);
             
             int updateCount=stmt.executeUpdate();

             return updateCount;
        }   
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

/**
 * MODIFICAR*********************************************************************************************************************************************************************
 */
public Integer modificar(Integer id, Date fechaEntrada, Date fechaSalida, Double valor, String formaPago) {
    try {
        final PreparedStatement stmt=con.prepareStatement("UPDATE reservas SET fecha_entrada = ?,fecha_salida=?,valor=?,forma_pago=? WHERE ID = ?");

            try(stmt){
                stmt.setDate(1,fechaEntrada);
                stmt.setDate(2,fechaSalida);
                stmt.setDouble(3,valor);
                stmt.setString(4,formaPago);
                
                stmt.setInt(6,id);

                int updateCount=stmt.executeUpdate();

                return updateCount;

            }
    } catch (SQLException e) {
       throw new RuntimeException(e);
    }
}
    

    /**
     * LISTAR(BUSCAR***********************************************************************************************************************************
     */
    public List<Reservas> listar() {    //MÉTODO BUSCAR

        List<Reservas> resultado = new ArrayList<Reservas>();
        
        try {
            
            final PreparedStatement stmt = con.prepareStatement("SELECT Id, Fecha_Entrada, Fecha_Salida, Valor, Forma_Pago FROM reservas");
            
            try(stmt) {
                
                final ResultSet rs = stmt.executeQuery();
                
                try(rs) {

                    while (rs.next()) {

                        var reservas=new Reservas(rs.getInt("ID"),
                                                  rs.getDate("FECHA_ENTRADA"),
                                                  rs.getDate("FECHA_SALIDA"),
                                                  rs.getDouble("VALOR"),
                                                  rs.getString("FORMA_PAGO"));
                        resultado.add(reservas);                          

                    }
                    
                }
            }    

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return resultado;
        }
    }    



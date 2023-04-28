package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Huespedes;
import com.hotel.jdbc.factory.ConnectionFactory;



public class HuespedesDAO {

    final private Connection con;

    public HuespedesDAO(Connection con) {
        this.con = con;
    }


/**
 * MODIFICAR*********************************************************************************************************************************************************************
 */
public Integer modificar(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, Integer celular) {
    try {
        final PreparedStatement stmt=con.prepareStatement("UPDATE HUESPEDES SET NOMBRE = ?,APELLIDO=?,FECHANACIMIENTO=?,NACIONALIDAD=?,CELULAR=? WHERE ID = ?");

            try(stmt){
                stmt.setString(1,nombre);
                stmt.setString(2,apellido);
                stmt.setDate(3,fechaNacimiento);
                stmt.setString(4,nacionalidad);
                stmt.setInt(5,celular);
                stmt.setInt(6,id);

                int updateCount=stmt.executeUpdate();

                return updateCount;

            }
    } catch (SQLException e) {
       throw new RuntimeException(e);
    }
}


/**
 * ELIMINAR****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
 */
public int eliminar(Integer id) {
    try {
        final PreparedStatement stmt=con.prepareStatement("DELETE FROM HUESPEDES WHERE ID=?");
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
 *GUARDAR**********************************************************************************************************************************************************************************
 */
public void guardar(Huespedes huespedes) {
    try(con) {
        final PreparedStatement stmt = con.prepareStatement("INSERT INTO huespedes(NOMBRE,APELLIDO,FECHANACIMIENTO,NACIONALIDAD,CELULAR,IDRESERVA"+
                                                                "VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                try(stmt) {
                        
                    ejecutarRegistro(huespedes, stmt);
                
                }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }    
}

private void ejecutarRegistro(Huespedes huespedes, PreparedStatement stmt) throws SQLException{
    
    stmt.setString(1,huespedes.getNombre());
    stmt.setString(2,huespedes.getApellido());
    stmt.setDate(3,huespedes.getFechaNacimiento());
    stmt.setString(4,huespedes.getNacionalidad());
    stmt.setInt(5,huespedes.getCelular());
    stmt.setInt(6,huespedes.getCategoriaId());

    stmt.execute();

    final ResultSet resultSet = stmt.getGeneratedKeys(); //Tomamos la ID generada

    try(resultSet) {
        
        while (resultSet.next()) {
            huespedes.setId(resultSet.getInt(1));

        }

    }
    
}

public List<Huespedes> listar() {
    
    List<Huespedes> resultadoLista = new ArrayList<>();

    try(con) {
        final PreparedStatement stmt = con.prepareStatement("SELECT * FROM HUESPEDES");

        try(stmt) {
            stmt.execute();
            final ResultSet rs = stmt.getResultSet();
            try(rs) {
                
                while (rs.next()) {
                    Huespedes fila = new Huespedes(rs.getInt("ID"),
                                                   rs.getString("NOMBRE"),
                                                   rs.getString("APELLIDO"),
                                                   rs.getDate("FECHANACIMIENTO"),
                                                   rs.getString("NACIONALIDAD"),
                                                   rs.getInt("CELULAR"));
                    resultadoLista.add(fila);
                }

            }
        
        }
        return resultadoLista;

    } catch (SQLException e) {
            throw new RuntimeException(e);
    }
}
    
}

package com.hotel.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    private DataSource datasource;

    public ConnectionFactory() {
        var pooledDataSource = new ComboPooledDataSource();

                pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimezone=true&serverTimezone=UTC");
                pooledDataSource.setUser("root");
                pooledDataSource.setPassword("5966438012MySQL"); 

                pooledDataSource.setMaxPoolSize(50);
                
        this.datasource=pooledDataSource;        
    }

    public Connection recuperaConexion() {
       
        try {
            return this.datasource.getConnection();
        } catch (SQLException e) {
          
           throw new RuntimeException(e);
        }
    }
}

package com.hotel.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    private DataSource datasource;

    public ConnectionFactory() {
        var ComboPooledDataSource = new ComboPooledDataSource();

                ComboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_administracion?useTimezone=true&serverTimezone=UTC");
                ComboPooledDataSource.setUser("root");
                ComboPooledDataSource.setPassword("5966438012MySQL"); 

                ComboPooledDataSource.setMaxPoolSize(50);
               
                
        this.datasource=ComboPooledDataSource;        
    }

    public Connection recuperaConexion() {
       
        try {
            return this.datasource.getConnection();
        } catch (SQLException e) {
          
           throw new RuntimeException(e);
        }
    }
}

/*Existen algunas buenas prácticas y recomendaciones que se pueden seguir para establecer el tamaño máximo de pool de conexiones de manera efectiva:

* Realizar pruebas de carga y monitorear el rendimiento de la aplicación para determinar el tamaño máximo de pool de conexiones adecuado.
*Establecer un tamaño máximo de pool de conexiones que sea suficiente para manejar la carga esperada de la aplicación, pero que no sobrecargue los recursos del servidor.
*Configurar el tamaño máximo de pool de conexiones de acuerdo con la capacidad de hardware del servidor y la capacidad de la base de datos.
*Utilizar herramientas de monitoreo para detectar y corregir problemas de rendimiento relacionados con la conexión a la base de datos, como la sobrecarga de conexiones o el tiempo de espera largo.

Aunque no hay un estándar específico para establecer el tamaño máximo de pool de conexiones, se pueden seguir las mejores prácticas y recomendaciones para determinar un tamaño adecuado que garantice el rendimiento óptimo de una aplicación.*/
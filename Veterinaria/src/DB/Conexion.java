
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection obtenerConexion(){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Nombre de nuestro JDBC
            
            //Establecer Conexion
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/veterinaria", "root", ""); //URL BD
            
            System.out.println(" Conectado");
        } catch(SQLException e){
            System.out.println("Error SQL " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return connection;
    }
}

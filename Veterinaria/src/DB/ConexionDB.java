
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Nombre de nuestro JDBC
            
            //Establecer Conexion
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/veterinaria", "root", ""); //URL BD
            
            System.out.println(" Conectado");
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}

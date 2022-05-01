/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DB.Conexion;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian Munoz Z
 */
public class MantenedorUsuario {
    //Registrar usuario
    public boolean registrarUsuario (Usuario usuario){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "INSERT INTO `usuarios`(`rut`, `dv`, `nombre`, `apellido`, `contraseña`) VALUES (?,?,?,?,?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(1, usuario.getRut());
            smtp.setInt(2, usuario.getDv());
            smtp.setString(3, usuario.getNombre());
            smtp.setString(4, usuario.getApellido());
            smtp.setInt(5, usuario.getContraseña());
            
            //Ejecutar
            smtp.executeUpdate();
            smtp.close();
            cnx.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL " + ex.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }
    
    public boolean iniciarSesion (Usuario user){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            Connection cnx = conexion.obtenerConexion();
            ResultSet rs = null;
            
            //Consulta
            String query = "SELECT `rut`, `contraseña` FROM `usuarios` WHERE rut = (?) AND contraseña = (?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(1, user.getRut());
            smtp.setInt(2, user.getContraseña());
            rs = smtp.executeQuery();
            
            if(rs.next()){
                if(String.valueOf(user.getContraseña()).equals(rs.getString(2))){
                    user.setRut(rs.getInt(1));
                    user.setContraseña(rs.getInt(2));
                    return true;
                } else {
                    return false;
                }
            }
            
            //Ejecutar
            smtp.close();
            cnx.close(); 
            return false;
        } catch (SQLException ex) {
            System.out.println("Error SQL " + ex.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }
}

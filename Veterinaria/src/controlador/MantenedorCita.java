
package controlador;


import DB.Conexion;
import modelo.Cita;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MantenedorCita {
    
    public boolean agendarCita (Cita cita){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            ResultSet rs = null;
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "INSERT INTO `cita`(`nombre_mascota`, `tipo_mascota`, `doctor`, `dia`, `mes`, `año`, `comentario`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setString(1, cita.getNombreMascota());
            smtp.setString(2, cita.getTipoMascota());
            smtp.setString(3, cita.getDoctor());
            smtp.setInt(4, cita.getDia());
            smtp.setInt(5, cita.getMes());
            smtp.setInt(6, cita.getAño());
            smtp.setString(7, cita.getComentario());
            
            smtp.executeUpdate();
            
            String query2 ="SELECT `nombre_mascota`, `doctor`, `tipo_mascota`, `id_cita` FROM `cita` WHERE nombre_mascota = (?) AND doctor = (?) AND tipo_mascota = (?) ";
            PreparedStatement smtp2 = cnx.prepareStatement(query2);
            
            
            smtp2.setString(1, cita.getNombreMascota());
            smtp2.setString(2, cita.getDoctor());
            smtp2.setString(3, cita.getTipoMascota());
            rs = smtp2.executeQuery();
            if(rs.next()){
                cita.setId(rs.getInt(4));
            }
            
            
            
            //Ejecutar
            
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
    
    public boolean eliminarCita (int id){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "DELETE FROM `cita` WHERE id_cita = (?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(1, id);
            
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
    
    public boolean verCita (Cita cita){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            ResultSet rs = null;
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "SELECT `id_cita`, `nombre_mascota`, `tipo_mascota`, `doctor`, `dia`, `mes`, `año` FROM `cita` WHERE id_cita = (?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(1, cita.getId());
            rs = smtp.executeQuery();
            if(rs.next()){
                cita.setNombreMascota(rs.getString(2));
                cita.setTipoMascota(rs.getString(3));
                cita.setDoctor(rs.getString(4));
                cita.setDia(rs.getInt(5));
                cita.setMes(rs.getInt(6));
                cita.setAño(rs.getInt(7));
                
            }
            
            //Ejecutar
           
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
    
    public boolean verModificarCita (Cita cita){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            ResultSet rs = null;
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "SELECT `id_cita`, `nombre_mascota` FROM `cita` WHERE id_cita = (?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(1, cita.getId());
            rs = smtp.executeQuery();
            if(rs.next()){
                cita.setNombreMascota(rs.getString(2));
                
            }
            
            //Ejecutar
           
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
    
    public boolean updateCita (Cita cita){
        try {
            //Conectar la BD con nuestra conexión
            Conexion conexion = new Conexion();
            ResultSet rs = null;
            Connection cnx = conexion.obtenerConexion();
            
            //Consulta
            String query = "UPDATE `cita` SET `nombre_mascota`=(?),`tipo_mascota`=(?),`doctor`=(?),`dia`=(?),`mes`=(?),`año`=(?),`comentario`=(?) WHERE id_cita = (?)";
            PreparedStatement smtp = cnx.prepareStatement(query);
            
            //Parametros
            smtp.setInt(8, cita.getId());
            
            
            
            smtp.setString(1, cita.getNombreMascota());
            smtp.setString(2, cita.getTipoMascota());
            smtp.setString(3, cita.getDoctor());
            smtp.setInt(4, cita.getDia());
            smtp.setInt(5, cita.getMes());
            smtp.setInt(6, cita.getAño());
            smtp.setString(7, cita.getComentario());
               
            
            
            
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
    
}

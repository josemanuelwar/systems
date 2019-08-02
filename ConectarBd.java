/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trasporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author josemanuel
 */
public class ConectarBd {
    
    Connection conectar=null;
    String Servidor = "localhost";
    String DB = "proyecto";
    String usuario = "root";
    String Contraseña ="";
    
    
    public Connection conexion(){
        
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        conectar=DriverManager.getConnection("jdbc:mysql://"+Servidor+"/"+DB,usuario,Contraseña);
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return conectar;
    }
    
    public void Insertar_Clientes(String rfc,String nombre, String direccion){
        
        try {
            
            PreparedStatement st = conectar.prepareStatement("INSERT INTO cliente VALUE (?,?,?)");
            st.setString(1,rfc);
            st.setString(2, nombre);
            st.setString(3, direccion);
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    public void Insetar_Fletes(String rfc,String origen,String Destino, float volumen, float peso,String redondo,float total) throws SQLException{
    
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO fletes  "
                + "VALUE (?,?,?,?,?,?,?)");
        
        stm.setString(1,rfc);
        stm.setString(2,origen);
        stm.setString(3,Destino);
        stm.setFloat(4,volumen);
        stm.setFloat(5,peso);
        stm.setString(6,redondo);
        stm.setFloat(7,total);
        
        stm.executeUpdate();
        
        
    }
    
    public void Cerrar_DB() throws SQLException{
        
        if (conectar != null){
            conectar.close();
        }
        
    }
}

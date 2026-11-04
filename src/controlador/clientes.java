/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.conexion_DB;

/**
 *
 * @author FREL DAVID
 */
public class clientes {
    Connection connection;
    private Integer id;
    private String Nombre;
    private String apellido;
    private String correo;
    
    public clientes(Integer ID,String NOMBRE,String APELLIDO,String CORREO ){
  this.id=ID;
  this.Nombre=NOMBRE;
  this.apellido=APELLIDO;
  this.apellido=APELLIDO;
  this.correo=CORREO;
    
         }
    //public clientes(Integer productId,String Nombre,String apellido,String correo){

    public clientes() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

          
    public Integer getId(){
    return id;
    }
    public String getNombre(){
    return Nombre;
  }
    public String getApellido(){
    return apellido;
    }
    public String getCorreo(){
        return correo;}
    
    
    public static void insertclientes(clientes clientes)
  {// crea el objeto de la clase conexion_DB
      Connection con=modelo.conexion_DB.getConnection();
   PreparedStatement ps;
  try{
      
   ps=con.prepareStatement("INSERT INTO clientes( Nombre,apellido,correo) VALUES (?,?,?)");
  ps.setString(1,clientes.getNombre());
   ps.setString(2,clientes.getApellido());
  ps.setString(3,clientes.getCorreo());
  

  if(ps.executeUpdate()!=0){
     
  JOptionPane.showMessageDialog(null,"nuevo usuario registrado");
  }
  else{
      JOptionPane.showMessageDialog(null,"no se pudo realizar el registro");
  }
  
  
  }catch(SQLException ex){
      Logger.getLogger(users.class.getName()).log(Level.SEVERE,null,ex);
      JOptionPane.showMessageDialog(null, "Error de SQL: " + ex.getMessage());
  }
  
  
 // } 
  
}
    
    public ArrayList<clientes>clientesList(){
    ArrayList<clientes>clientes_list= new ArrayList<>();
    connection = conexion_DB.getConnection();
    ResultSet rs;
    PreparedStatement ps;
    String query =" SELECT idclientes, Nombre,apellido, correo FROM clientes";
    try{
    ps= connection.prepareStatement(query);
    rs=ps.executeQuery();
    clientes clientes;
    while(rs.next()){
    clientes= new clientes(rs.getInt("idclientes"),
            rs.getString("Nombre"), 
            rs.getString("apellido"),
            rs.getString("correo")
    );
    clientes_list.add(clientes);
    }
    
    }catch(SQLException ex){
    Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
    }
    return clientes_list;
            
            
    } 

    
           
    
    
}

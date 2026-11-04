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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.conexion_DB;


/**
 *
 * @author FREL DAVID
 */
public class productos{

    public static void deleteproducto(int nombre_producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection connection;
    private Integer id;
    private String nombre;
    private String precio;
    private String descripcion;
    private String ubicacion;
    
    public productos(Integer ID,String NOMBRE,String PRECIO, String DESCRIPCION,String UBICACION ){
  this.id=ID;
  this.nombre=NOMBRE;
  this.precio=PRECIO;
  this.descripcion=DESCRIPCION;
  this.ubicacion=UBICACION;
    
         }
    //public clientes(Integer productId,String Nombre,String apellido,String correo){

    public productos() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
          
    public Integer getId(){
    return id;
    }
    public String getNombre(){
    return nombre;
  }
    public String getPrecio(){
    return precio;
    }
    public String getDescripcion(){
    return descripcion;
    }
    public String getUbicacion(){
        return ubicacion;}
    
    
    public static void insertproductos(productos productos)
  {// crea el objeto de la clase conexion_DB
      Connection con=modelo.conexion_DB.getConnection();
   PreparedStatement ps;
  try{
      
   ps=con.prepareStatement("INSERT INTO productos( nombre,precio,descripcion,ubicacion) VALUES (?,?,?,?)");
  ps.setString(1,productos.getNombre());
  ps.setString(2,productos.getPrecio());
   ps.setString(3,productos.getDescripcion());
  ps.setString(4,productos.getUbicacion());
  

  if(ps.executeUpdate()!=0){
     
  JOptionPane.showMessageDialog(null,"producto ingresado");
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
    
    public ArrayList<productos>productosList(){
    ArrayList<productos>productos_List= new ArrayList<>();
    connection = conexion_DB.getConnection();
    ResultSet rs;
    PreparedStatement ps;
    String query =" SELECT id, nombre,precio, descripcion,ubicacion FROM productos";
    try{
    ps= connection.prepareStatement(query);
    rs=ps.executeQuery();
    productos productos;
    while(rs.next()){
    productos = new productos(rs.getInt("id"),
            rs.getString("nombre"), 
            rs.getString("precio"),
            rs.getString("descripcion"),
            rs.getString("ubicacion")
    );
    productos_List.add(productos);
    }
    
    }catch(SQLException ex){
    Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    return productos_List;
            
            
    } 
public static void deleteproductos(Integer id){
Connection con= modelo.conexion_DB.getConnection();
PreparedStatement ps;
try{
ps=con.prepareStatement("DELETE FROM productos WHERE id=?");
ps.setInt(1, id);

int YesOrNo =JOptionPane.showConfirmDialog(null,"realmente quieres eliminarlo","eliminar usuario",2);
if(YesOrNo==0){
if(ps.executeUpdate() !=0){
JOptionPane.showMessageDialog(null,"eliminar producto");
}
else{
JOptionPane.showMessageDialog(null,"Something wrong");
}
}

}catch(SQLException e){
    //imprime lo que fALLO
e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
    }


}
    
    
}

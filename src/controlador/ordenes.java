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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.conexion_DB;

/**
 *
 * @author FREL DAVID
 */
public class ordenes {

    public static void insertordenes(Integer orderId, String orderDate, Integer valueOf) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void insertordenesDetails(Integer productId, Integer orderId, Integer qty, String precio, String total) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Object[]> listarTodasLasOrdenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection connection;
    private Integer id;
    private String nombre;
    private String precios;
    private String cantidad;
    private String valor;
    
    public ordenes(Integer ID,String NOMBRE,String PRECIOS,String CANTIDAD, String VALOR  ){
  this.id=ID;
  this.nombre=NOMBRE;
  this.precios=PRECIOS;
  this.cantidad=CANTIDAD;
  this.valor=VALOR;
    
         }
    //public clientes(Integer productId,String Nombre,String apellido,String correo){

    public ordenes() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

          
    public Integer getId(){
    return id;
    }
    public String getNombre(){
    return nombre;
  }
    public String getPrecios(){
    return precios;
    }
    public String getCantidad(){
        return cantidad;}
    public String getValor(){
    return valor;
    }
    
    public static void insertordenes(ordenes ordenes)
  {// crea el objeto de la clase conexion_DB
      Connection con=modelo.conexion_DB.getConnection();
   PreparedStatement ps;
  try{
      
   ps=con.prepareStatement("INSERT INTO ordenes( nombre,precios,cantidad,valor) VALUES (?,?,?,?)");
  ps.setString(1,ordenes.getNombre());
   ps.setString(2,ordenes.getPrecios());
  ps.setString(3,ordenes.getCantidad());
  ps.setString(4,ordenes.getValor());
  

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
    
    public ArrayList<ordenes>ordenesList(){
    ArrayList<ordenes>ordenes_list= new ArrayList<>();
    connection = conexion_DB.getConnection();
    ResultSet rs;
    PreparedStatement ps;
    String query =" SELECT id, nombre,precios,cantidad, valor FROM ordenes";
    try{
    ps= connection.prepareStatement(query);
    rs=ps.executeQuery();
    ordenes ordenes;
    while(rs.next()){
    ordenes= new ordenes(rs.getInt("id"),
            rs.getString("nombre"), 
            rs.getString("precio"),
            rs.getString("cantidad"),
             rs.getString("valor")
    );
    ordenes_list.add(ordenes);
    }
    
    }catch(SQLException ex){
    Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ordenes_list;
            
            
    } 

    

    

    public int getMaxorderId() {
      //
int id=0;
return id;
    }



   
    
}

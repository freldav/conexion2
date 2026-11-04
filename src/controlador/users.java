 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.lang.Character.getName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author FREL DAVID
 */
public class users {
    Connection connection;
    private Integer id;
    private String nombre;
    private String contrasena;
    private String apellido;
    private String email;
    private String telefono;
    private String genero;
    private byte[] Imagen;
    public users(){
    }
  public users(Integer ID,String NOMBRE,String APELLIDO,String CONTRASENA,String EMAIL,String TELEFONO, String GENERO,byte[]IMAGEN ){
  this.id=ID;
  this.nombre=NOMBRE;
  this.apellido=APELLIDO;
  this.contrasena=CONTRASENA;
  //this.email=EMAIL;
  this.email=EMAIL;
  this.telefono=TELEFONO;
  this.genero= GENERO;
  this.Imagen=IMAGEN;
  }  

    public users(Integer productId, String nombre, String apellido, String sha1, String telefono, String genero,byte[]Imagen) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public Integer getId(){
      return id;
  }  
    public String getNombre(){
    return nombre;
    }
    public String getApellido(){
    return apellido;
    }
     public String getContrasena(){
     return contrasena;
     }
     
   public String getEmail(){
     return email;
     } 
    public String getTelefono(){
    return telefono;
    }
    public String getGenero(){
    return genero;
    }
    public byte[] getImagen(){
      return Imagen;
    }
    public void setImagen(byte[]imagen){
    this.Imagen=imagen;
    }
    
  public static void insertuser(users users)
  {// crea el objeto de la clase conexion_DB
      Connection con=modelo.conexion_DB.getConnection();
   PreparedStatement ps;
  try{
      
   ps=con.prepareStatement("INSERT INTO users( nombre,apellido,contrasena, email,telefono,genero,Imagen) VALUES (?,?,?,?,?,?,?)");
  ps.setString(1,users.getNombre());
   ps.setString(2,users.getApellido());
  ps.setString(3, users.getContrasena());
  ps.setString(4, users.getEmail());
  ps.setString (5,users.getTelefono());
  ps.setString(6, users.getGenero());
     ps.setBytes(7,users.getImagen());

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
//getusers list
public ArrayList<users>usersList(){
ArrayList<users> user_List= new ArrayList<>();
connection=modelo.conexion_DB.getConnection();
ResultSet rs;
PreparedStatement ps;
String query="SELECT Id,nombre,apellido,contrasena,email,telefono,genero,Imagen FROM users";

    try{ ps=connection .prepareStatement(query);
    rs=ps.executeQuery();
    users user;
    while(rs.next()){
    user = new users(rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("apellido"),
            rs.getString("contrasena"),
            rs.getString("email"),
            rs.getString("telefono"),
            rs.getString("genero"),
            rs.getBytes("Imagen")
    );
            
           // user.setImagen(rs.getBytes("imagen"));
    
    user_List.add(user);
    }
    
    }catch(SQLException ex){
      Logger.getLogger(users.class.getName()).log(Level.SEVERE,null, ex);
    }
            

        return user_List;
}
public static void updateusers(users user, boolean changeImagen){
Connection con = modelo.conexion_DB.getConnection();
PreparedStatement ps;

if(changeImagen){
try{
ps=con.prepareStatement("UPDATE users SET nombre =?,apellido=?,contrasena=?,email=?,telefono=?,genero=?,imagen=? WHERE id=?;");
ps.setString(1,user.getNombre());
ps.setString(2,user.getApellido());
ps.setString(3,user.getContrasena());
ps.setString(4,user.getEmail());
ps.setString(5,user.getTelefono());
ps.setString(6,user.getGenero());
ps.setBytes(7,user.getImagen());
ps.setInt(8, user.getId());

if(ps.executeUpdate()!=0){
JOptionPane.showMessageDialog(null,"usuario actualizado");

}
else{
JOptionPane.showMessageDialog(null,"no se encontro el ID para actualizar");
}
}catch(SQLException ex){
 Logger.getLogger(users.class.getName()).log(Level.SEVERE,null,ex);
 JOptionPane.showMessageDialog(null,"error critico SQL(con imagen):"+ ex.getMessage());
}

}



}
//eliminar producto por id
public static void deleteusers(Integer id){
Connection con= modelo.conexion_DB.getConnection();
PreparedStatement ps;
try{
ps=con.prepareStatement("DELETE FROM users WHERE id=?");
ps.setInt(1, id);

int YesOrNo =JOptionPane.showConfirmDialog(null,"realmente quieres eliminarlo","eliminar usuario",2);
if(YesOrNo==0){
if(ps.executeUpdate() !=0){
JOptionPane.showMessageDialog(null,"eliminar usuario");
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

   // public Object getImagen() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}





}


//paquete






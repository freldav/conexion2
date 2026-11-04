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
import modelo.conexion_DB;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author FREL DAVID
 */
public class categoria {
    Connection connection;
    private Integer id;
    private String Nombre;
    public Integer getId(){
    return id;
    }
    public String getNombre(){
    return Nombre;
  }
    public Integer getcategoria(String Nombre){
    return this.id;
    }
    public void setNombre(String Nombre){
    this.Nombre=Nombre;
    }
    public categoria(){}
    public categoria(Integer ID,String Nombre){
    this.id=ID;
    this.Nombre=Nombre;
    
    }
    public ArrayList<categoria>categorialist(){
    ArrayList<categoria>categoria_list= new ArrayList<>();
    connection = conexion_DB.getConnection();
    ResultSet rs;
    PreparedStatement ps;
    String query =" SELECT id, Nombre FROM categoria";
    try{
    ps= connection.prepareStatement(query);
    rs=ps.executeQuery();
    categoria categoria;
    while(rs.next()){
    categoria = new categoria(rs.getInt("id"), rs.getString("Nombre"));
    categoria_list.add(categoria);
    }
    
    }catch(SQLException ex){
    Logger.getLogger(categoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return categoria_list;
            
            
    } 
           
    
    public HashMap<String,Integer>populateCombo(){
    HashMap<String, Integer>map= new HashMap();
   
    connection =  conexion_DB.getConnection();
    Statement st;
    ResultSet rs;
    try{
        st=connection.createStatement();
    rs=st.executeQuery("SELECT id, Nombre FROM categoria");
           categoria categoria;
           while(rs.next()){
           categoria= new categoria(rs.getInt(1), rs.getString(2));
           map.put(categoria.getNombre(), categoria.getId());
           
           }
    }catch (SQLException ex){
                 Logger.getLogger(categoria.class.getName()). log(Level.SEVERE,null,ex);
                   }
         return map;
    }
    
    
}

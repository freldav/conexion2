/*
 * To change this license header, choose License eaders in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author FREL DAVID
 */
public class conexion_DB {
    private static String dbname="polifunciones_sena";
    private static String nombre="root";
    private static String contrasena="";
    
    static Connection con=null;
    public static Connection getConnection(){
     if(con !=null)return con;
     return getConnection(dbname,nombre,contrasena);
 }

    private static Connection getConnection(String db_name, String nombre, String contrasena){
 try{
 Class.forName("com.mysql.cj.jdbc.Driver");
  String url = "jdbc:mysql://localhost:3306/" + db_name + "?user=" + nombre + "&password=" + contrasena + "&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
 con = DriverManager.getConnection(url);
 System.out.print("connected");
 
 
 }
 catch(Exception e)   
 { 

      System.err.println("Error al intentar conectar a MySQL: " + e.getMessage());
        e.printStackTrace();
        con = null; 
 }
 return con;
 }  
}

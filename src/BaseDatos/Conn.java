/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Conn {
     String IP;
     String Puerto;
     String BD;
     String Usuario;
     String Clave;
     public Connection conn;
     public Conn(){
          this.IP="";
          this.Puerto="";
          this.BD="";
          this.Usuario="";
          this.Clave=""; 
          this.conn = null;
     }
     public Connection mkConnRe() throws Exception {
                try{
                  /*Datos de la BD*/
                  this.IP      = "localhost";
                  this.Puerto  = "3306";
                  this.BD      = "asuna";
                  this.Usuario = "root";
                  this.Clave   = "miguelangel1";
                  String driver = "com.mysql.jdbc.Driver";
                  String url = "jdbc:mysql://"+this.IP+":"+this.Puerto+"/"+this.BD+
                          "?noAccessToProcedureBodies=true&amp;zeroDateTimeBehavior=convertToNull";  
                  Class.forName(driver).newInstance();
		  this.conn = DriverManager.getConnection(url,this.Usuario,this.Clave);
                }catch(Exception e){
                  e.printStackTrace();
                }                                
           return this.conn;
        }
}
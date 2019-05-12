/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_crud;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pooja
 */
public class Db_connection {
    
    public static void main(String[] args){
     Db_connection obj_db_connection=new Db_connection();
     System.out.println(obj_db_connection.get_connection());
    }
    
    public Connection get_connection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1/crud","root","");
            
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
    
}

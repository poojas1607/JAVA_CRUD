/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Pooja
 */
public class MYSQL_CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MYSQL_CRUD objtest=new MYSQL_CRUD();
       objtest.create_data("1","pooja","pooja16@gmail.com");
       objtest.create_data("4","sarthak","sarthak28@gmail.com");
        //objtest.read_data("1");
        objtest.update_data("4","8","vishu","vishu17@gmail.com");
        //objtest.delete_data("2");
        
    }
    
    public void create_data(String s1_no,String name,String email){
          Db_connection obj_db_connection=new Db_connection();
          Connection connection=obj_db_connection.get_connection();
          PreparedStatement pa=null;
          ResultSet  rs=null;
          try{
             
              String query="insert into user(s1_no,name,email) values(?,?,?)";
              pa=connection.prepareStatement(query);
              pa.setString(1,s1_no);
              pa.setString(2,name);
              pa.setString(3,email);
              System.out.println(pa);
              pa.executeUpdate();
              
          }catch(Exception e)
          {
              System.out.println(e);
          }
    }
    
    public void read_data(String s)
    {
        Db_connection obj_db_connection=new Db_connection();
        Connection connection=obj_db_connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String query="select * from user where s1_no=?";
            ps=connection.prepareStatement(query);
            ps.setString(1,s);
            System.out.println(ps);
            rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println("S1 no-"+rs.getString("s1_no"));
                System.out.println("Name-"+rs.getString("name"));
                System.out.println("Email-"+rs.getString("email"));
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void update_data(String s,String s1,String name,String email)
    {
        Db_connection db_obj_connection=new Db_connection();
        Connection connection=db_obj_connection.get_connection();
        PreparedStatement ps=null;
        try{
            String query="update user set s1_no=?,name=?,email=? where s1_no=?";
            ps=connection.prepareStatement(query);
            ps.setString(1,s1);
              ps.setString(2,name);  
              ps.setString(3,email); 
              ps.setString(4,s);
              ps.executeUpdate();
              
              
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void delete_data(String s)
    {
        Db_connection db_obj_connection=new Db_connection();
        Connection connection=db_obj_connection.get_connection();
        PreparedStatement ps=null;
        try{
            String query="delete from  user where s1_no=?";
            ps=connection.prepareStatement(query);
            ps.setString(1,s);
            System.out.println(ps);
            ps.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.dao;
import dbConnection.dbutil.DbConnection;
import hms.pojo.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Users 
{
    String[]arr=new String[2];
     public  String[] login(User e) throws SQLException
     {
    
         PreparedStatement ps=DbConnection.getConnection().prepareStatement("select username,empid from users where userid=? and password=? and usertype=?");
         ps.setString(1,e.getUserId());
        ps.setString(2,e.getPassword());
        ps.setString(3,e.getUserType());
        ResultSet rs=ps.executeQuery();
  
        String uname="";
        if(rs.next())
        {
            arr[0]=rs.getString(1);
            arr[1]=rs.getString(2);
        } 
        return arr;
         
         
         
     } 
    
    
}

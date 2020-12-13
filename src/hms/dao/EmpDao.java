/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.dao;

import dbConnection.dbutil.DbConnection;
import hms.pojo.EmpPojo;
import hms.pojo.RecepPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class EmpDao {
    public static String getUId () throws SQLException
    {
             PreparedStatement ps=DbConnection.getConnection().prepareStatement("select max (to_number(substr(empid,5))) from employees"); 
                 ResultSet rs=ps.executeQuery();
                 int id=1;
                 rs.next();
                 {
                      
                    String empid= rs.getString(1);
                    int eno=Integer.parseInt(empid);
                    id=id+eno;
                     
                 }
                 String str="EMP-"+id;
                 System.out.println(str);
                         return str;
        
        
    }
      public static boolean addEmployees (EmpPojo e) throws SQLException
    {
              PreparedStatement ps=DbConnection.getConnection().prepareStatement("insert into employees values(?,?,?,?)"); 
              ps.setString(1,e.getEmpid());
              ps.setString(2,e.getEmpname());
              ps.setString(3,e.getJob());
              ps.setDouble(4,e.getSal());
              System.out.println();
              int rs=ps.executeUpdate();
                if(rs==1)
                    return true;
                return false;
} 
                                 


      public static ArrayList <EmpPojo> viewall()  throws SQLException
              {
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from employees");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<EmpPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      EmpPojo e=new EmpPojo();
                      e.setEmpid(rs.getString(1));
                      e.setEmpname(rs.getString(2));
                      e.setJob(rs.getString(3));
                      e.setSal(rs.getDouble(4));
                      arr.add(e);
                      
                  }
                  return arr;
              }
       public static boolean deleteEmp(String eno) throws SQLException
             {
                 PreparedStatement ps=DbConnection.getConnection().prepareStatement("delete from employees where empid=?");
                   PreparedStatement qs=DbConnection.getConnection().prepareStatement("delete from users where empid=?");
                 ps.setString(1,eno);
                 qs.setString(1,eno);
                int rs= ps.executeUpdate();
                int u=qs.executeUpdate();
                if(rs>0)
                 return true;
                return false;
             }
      public static ArrayList <String> allEid () throws SQLException
      {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("select empid  from employees");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<String> arr=new ArrayList();
                  while (rs.next())
                  {
                     
                    arr.add( rs.getString(1));
                      
                  }
                  
                  return arr;
          
      }
      public static EmpPojo Us(String id)  throws SQLException
              {
                  System.out.println("ahimayu");
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from employees where empid=?");
                  ps.setString(1,id);
                  ResultSet rs=ps.executeQuery();
                 EmpPojo e=null;

                       if(rs.next())
                       {
                       e=new EmpPojo();
                      e.setEmpid(rs.getString(1));
                      e.setEmpname(rs.getString(2));
                      e.setJob(rs.getString(3));
                      e.setSal(rs.getDouble(4));
                      System.out.println(e);
                      return e;
                      
                  
              }
                       return e;
        
              }   
             public static boolean Update(EmpPojo u) throws SQLException
     {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("update employees set empname=?,sal=?,role=? where empid=?");
         
                  ps.setString(1,u.getEmpname());
                  ps.setDouble(2,u.getSal());
                  ps.setString(3,u.getJob());
                  ps.setString(4,u.getEmpid());
                    int rs=ps.executeUpdate();
                    if(rs==1)
                        return true;
                    return false;
                    
                     
                     
                 }
             public static HashMap<String, String> getNotRegisterRecepList()throws SQLException          
             {
                 
                 Connection conn=DbConnection.getConnection();
                 String qry= "Select empid,empname from employees where role='RECEPTIONIST'and empid not in (select empid from users where usertype='RECEPTIONIST')";
                  Statement st=conn.createStatement();
                  ResultSet rs=st.executeQuery(qry);
                  HashMap<String,String> receptionist=new HashMap();
                  while(rs.next())
                  {
                      String id=rs.getString(1);
                      String name=rs.getString(2);
                      receptionist.put(id,name);
                      
                  }
                  return receptionist;
                  }
              

}


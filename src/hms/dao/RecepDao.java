/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.dao;

import dbConnection.dbutil.DbConnection;
import hms.pojo.DoctorPojo;
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
public class RecepDao 
{
    public static boolean addRecep(RecepPojo e) throws SQLException
    {
        
              PreparedStatement ps=DbConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)"); 
              System.out.println(e);
              ps.setString(1,e.getUserid());
              ps.setString(2,e.getUsername());
              ps.setString(3,e.getEmpid());
              ps.setString(4,e.getPassword());
               ps.setString(5,e.getUsertype()); 
               int rs=ps.executeUpdate();
                if(rs==1)
                    return true;
                return false;
                                 
}
          public static ArrayList <RecepPojo> viewallRe()  throws SQLException
              {
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from users where usertype='RECEPTIONIST' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<RecepPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      RecepPojo e=new RecepPojo();
                      e.setUserid(rs.getString(1));
                      e.setUsername(rs.getString(2));
                      e.setEmpid(rs.getString(3));
                      e.setPassword(rs.getString(4));
                      e.setUsertype(rs.getString(5));
                      arr.add(e);
                      
                  }
                  return arr;
              }
           public static ArrayList <RecepPojo> viewallDoctor()  throws SQLException
              {
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from users where usertype='DOCTOR' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<RecepPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      RecepPojo e=new RecepPojo();
                      e.setUserid(rs.getString(1));
                      e.setUsername(rs.getString(2));
                      e.setEmpid(rs.getString(3));
                      e.setPassword(rs.getString(4));
                      e.setUsertype(rs.getString(5));
                      arr.add(e);
                      
                  }
                  return arr;
              }
                 public static ArrayList <String> allRecepid () throws SQLException
      {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("select empid  from users where usertype='RECEPTIONIST' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<String> arr=new ArrayList();
                  while (rs.next())
                  {
                     
                    arr.add( rs.getString(1));
                      
                  }
                  
                  return arr;
          
      }
                   public static boolean deleteRecep(String eno) throws SQLException
             {
                 PreparedStatement ps=DbConnection.getConnection().prepareStatement("delete from users where empid=?");
                 ps.setString(1,eno);
                int rs= ps.executeUpdate();
                if(rs>0)
                 return true;
                return false;
             }
        public static ArrayList <String> allDoctorid () throws SQLException
      {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("select empid  from users where usertype='DOCTOR' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<String> arr=new ArrayList();
                  while (rs.next())
                  {
                     
                    arr.add( rs.getString(1));
                      
                  }
                  
                  return arr;
          
      }
            public static HashMap<String, String> getRegisteredRece()throws SQLException          
             {
                 
                 Connection conn=DbConnection.getConnection();
                 String qry= "Select userid,username from users  where usertype='RECEPTIONIST' ";
                  Statement st=conn.createStatement();
                   //System.out.println("fffffffffffffffffffffffff");
                  ResultSet rs=st.executeQuery(qry);
                   //System.out.println("fffffffffffffffffffffffff");
                  HashMap<String,String> receptionist=new HashMap();
                  while(rs.next())
                  {
                      //System.out.println("fffffffffffffffffffffffff");
                      String id=rs.getString(1);
                      String name=rs.getString(2);
                      receptionist.put(id,name);
                      
                  }
                  return receptionist;
                  }
            public static boolean changePassword(String userid,String pwd) throws SQLException
            {
               PreparedStatement ps=DbConnection.getConnection().prepareStatement("update users set password =? where userid=? ");
               ps.setString(1,pwd);
               ps.setString(2,userid);
               return(ps.executeUpdate()!=0);
               
                
            }
            public static HashMap<String, String> getNotRegisterDOC()throws SQLException          
             {
                 
                 Connection conn=DbConnection.getConnection();
                 String qry= "Select empid,empname from employees where role='DOCTOR'and empid not in (select empid from users where usertype='DOCTOR')";
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
             public static boolean addDoc(RecepPojo e) throws SQLException
    {
        
              PreparedStatement ps=DbConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)"); 
              System.out.println(e);
              ps.setString(1,e.getUserid());
              ps.setString(2,e.getUsername());
              ps.setString(3,e.getEmpid());
              ps.setString(4,e.getPassword());
               ps.setString(5,e.getUsertype()); 
               int rs=ps.executeUpdate();
                if(rs==1)
                    return true;
                return false;
                                 
}
           public static boolean addQDoc(DoctorPojo e) throws SQLException
    {
        
              PreparedStatement ps=DbConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?)"); 
              System.out.println(e);
              ps.setString(1,e.getUserid());
              ps.setString(2,e.getDoctorid());
              ps.setString(3,e.getQualification());
              ps.setString(4,e.getSpecialist());
      
               int rs=ps.executeUpdate();
                if(rs==1)
                    return true;
                return false;
                                 
}
             public static ArrayList <String> allDocid () throws SQLException
      {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("select empid  from users where usertype='DOCTOR' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<String> arr=new ArrayList();
                  while (rs.next())
                  {
                     
                    arr.add( rs.getString(1));
                      
                  }
                  
                  return arr;
          
      }
                    public static ArrayList <RecepPojo> viewPDo()  throws SQLException
              {
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from users where usertype='DOCTOR' ");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<RecepPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      RecepPojo e=new RecepPojo();
                      e.setUserid(rs.getString(1));
                      e.setUsername(rs.getString(2));
                      e.setEmpid(rs.getString(3));
                      e.setPassword(rs.getString(4));
                      e.setUsertype(rs.getString(5));
                      arr.add(e);
                      
                  }
                  return arr;
              }
                     public static HashMap<String, String> getRegisteredDo()throws SQLException          
             {
                 
                 Connection conn=DbConnection.getConnection();
                 String qry= "Select userid,username from users  where usertype='DOCTOR' ";
                  Statement st=conn.createStatement();
                   //System.out.println("fffffffffffffffffffffffff");
                  ResultSet rs=st.executeQuery(qry);
                   //System.out.println("fffffffffffffffffffffffff");
                  HashMap<String,String> receptionist=new HashMap();
                  while(rs.next())
                  {
                      //System.out.println("fffffffffffffffffffffffff");
                      String id=rs.getString(1);
                      String name=rs.getString(2);
                      receptionist.put(id,name);
                      
                  }
                  return receptionist;
                  }
                        public static boolean deletedoc(String eno) throws SQLException
             {
                 PreparedStatement ps=DbConnection.getConnection().prepareStatement("update users set usertype='DOCTORS' where empid=?");
                 ps.setString(1,eno);
                int rs= ps.executeUpdate();
                if(rs>0)
                 return true;
                return false;
             }
            
             
}

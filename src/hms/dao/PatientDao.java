/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.dao;

import dbConnection.dbutil.DbConnection;
import hms.pojo.PatientPojo;
import hms.pojo.UserProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class PatientDao  
{
    public static boolean addPatient(PatientPojo o) throws SQLException
{
    System.out.println(o);
    PreparedStatement ps=DbConnection.getConnection().prepareStatement(" insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?)");
     ps.setString(1, o.getP_id());
     ps.setString(2, o.getF_Name());
      ps.setString(3,o.getS_Name());
     ps.setInt(4, o.getAge());
     ps.setString(5,o.getOpd());
     ps.setString(6,o.getGender());
     ps.setString(7,o.getM_Status());
     ps.setDate(8,o.getD());
     ps.setString(9,o.getAddress());
     ps.setString(10,o.getCity());
     ps.setString(11,o.getmNo());
     ps.setString(12,o.getDoctor_id());
     int rs=ps.executeUpdate();
                if(rs==1)
                    return true;
                return false;
}
    public static String getNewId() throws SQLException
    {
{
    PreparedStatement ps;
    ps = DbConnection.getConnection().prepareStatement("select max (to_number(substr(p_id,5))) from Patients");
    ResultSet rs=ps.executeQuery();
                 int id=1;
                 rs.next();
                 {
                      
                    String Pid= rs.getString(1);
                    int eno=Integer.parseInt(Pid);
                    id=id+eno;
                     
                 }
                 String str="PAT-"+id;
                 System.out.println(str);
                         return str;
        
    
}

    }
    
      public static ArrayList <PatientPojo> viewDoPat()  throws SQLException
              {
                  System.out.println("aaaaaa");
                  String docid=UserProfile.getEmpid();
                  System.out.println(docid);
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from patients where doctor_id=?");
                  ps.setString(1, docid);
                  ResultSet rs=ps.executeQuery();
                  ArrayList<PatientPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      PatientPojo e=new PatientPojo();
                      e.setP_id(rs.getString(1));
                      e.setF_Name(rs.getString(2));
                      e.setS_Name(rs.getString(3));
                      e.setAge(rs.getInt(4));
                      e.setOpd(rs.getString(5));
                      e.setGender(rs.getString(6));
                      e.setM_Status(rs.getString(7));
                      e.setD(rs.getDate(8));
                      e.setAddress(rs.getString(9));
                      e.setCity(rs.getString(10));
                      e.setmNo(rs.getString(11));
                      e.setDoctor_id(rs.getString(12));
                      
                      
                      
                      arr.add(e);
                      
                  }
                  return arr;
              }
       public static ArrayList <PatientPojo> viewallPat() throws SQLException
              {
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from patients");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<PatientPojo> arr=new ArrayList();
                  while (rs.next())
                  {
                      PatientPojo e=new PatientPojo();
                      e.setP_id(rs.getString(1));
                      e.setF_Name(rs.getString(2));
                      e.setS_Name(rs.getString(3));
                      e.setAge(rs.getInt(4));
                      e.setOpd(rs.getString(5));
                      e.setGender(rs.getString(6));
                      e.setM_Status(rs.getString(7));
                      e.setD(rs.getDate(8));
                      e.setAddress(rs.getString(9));
                      e.setCity(rs.getString(10));
                      e.setmNo(rs.getString(11));
                      e.setDoctor_id(rs.getString(12));
                      
                      
                      
                      arr.add(e);
                      
                  }
                  return arr;
              }
           public static ArrayList <String> allPid () throws SQLException
      {
          PreparedStatement ps=DbConnection.getConnection().prepareStatement("select p_ID from patients");
                  ResultSet rs=ps.executeQuery();
                  ArrayList<String> arr=new ArrayList();
                  while (rs.next())
                  {
                     
                    arr.add( rs.getString(1));
                      
                  }
                  
                  return arr;
          
      }
                     public static boolean deletepat(String eno) throws SQLException
             {
                 PreparedStatement ps=DbConnection.getConnection().prepareStatement("delete from patients where P_ID=?");
                 ps.setString(1,eno);
                int rs= ps.executeUpdate();
                if(rs>0)
                 return true;
                return false;
             }
                     public static PatientPojo UpdatePat(String patientid) throws SQLException
              {
                  System.out.println(patientid);
                  PreparedStatement ps=DbConnection.getConnection().prepareStatement("select * from patients where P_ID=?");
                  ps.setString(1,patientid);
                  ResultSet rs=ps.executeQuery();
                 // System.out.println("abhimannyu gupta");
                  PatientPojo e=new PatientPojo();
                  while (rs.next())
                  {
                     // PatientPojo e=new PatientPojo();
                      e.setP_id(rs.getString(1));
                      e.setF_Name(rs.getString(2));
                      e.setS_Name(rs.getString(3));
                      e.setAge(rs.getInt(4));
                      e.setOpd(rs.getString(5));
                      e.setGender(rs.getString(6));
                      e.setM_Status(rs.getString(7));
                      e.setD(rs.getDate(8));
                      e.setAddress(rs.getString(9));
                      e.setCity(rs.getString(10));
                      e.setmNo(rs.getString(11));
                      e.setDoctor_id(rs.getString(12));
                      
                      
                      
                           //arr.add(e);
                      
                  }
                  return e;
              }
 public static boolean UpdateFinalPatient(PatientPojo o) throws SQLException
{
    System.out.println(o);
    PreparedStatement ps=DbConnection.getConnection().prepareStatement("update patients set f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?,address=?,city=?,phone_no=?,doctor_id=?  where p_id=?");
     // ps.setString(1, o.getP_id());
      ps.setString(1, o.getF_Name());
      ps.setString(2,o.getS_Name());
     ps.setInt(3, o.getAge());
     ps.setString(4,o.getOpd());
     ps.setString(5,o.getGender());
     ps.setString(6,o.getM_Status());
     ps.setDate(7,o.getD());
     ps.setString(8,o.getAddress());
     ps.setString(9,o.getCity());
     ps.setString(10,o.getmNo());
     ps.setString(11,o.getDoctor_id());
     ps.setString(12, o.getP_id());
     int rs=ps.executeUpdate();
     
                if(rs==1)
                    return true;
                return false;
}

                  
 
    
} 

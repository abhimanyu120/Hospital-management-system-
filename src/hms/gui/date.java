/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class date 
{
    public static void main(String[] args) {
         Connection conn;
   
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-4CUJJGE/xe", "system", "system");
            Statement st=conn.createStatement();
           
           ResultSet rs= st.executeQuery("select to_char(sysdate,'hh:mi:ss') from dual");
           rs.next();
            String time=rs.getString(1);
            System.out.println(time);
            System.err.println(time);
            
                   
    }
         catch(ClassNotFoundException cnfe)
                     {
                     JOptionPane.showMessageDialog(null,"Cannot LOad db","Error",JOptionPane.ERROR_MESSAGE);
                     cnfe.printStackTrace();
                     }
             catch(SQLException sqle)
                     {
                     JOptionPane.showMessageDialog(null,"problem in db","Error",JOptionPane.ERROR_MESSAGE);
                     sqle.printStackTrace();
                     } 
    
    
    }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public   class DbConnection
{
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-4CUJJGE/xe", "hms", "hms");
            
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
    
        public static Connection getConnection()
        {
            return conn;
        }
        public static void closeConnection()
        {
            try
            {
                if(conn!=null)
                {
                    conn.close();
                }
            }
              catch(SQLException sqle)
                     {
                     JOptionPane.showMessageDialog(null,"problem in db","Error",JOptionPane.ERROR_MESSAGE);
                     sqle.printStackTrace();
                     }
            
        }
        
    }


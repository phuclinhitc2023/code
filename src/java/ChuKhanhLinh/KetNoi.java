/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChuKhanhLinh;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;
import java.sql.*;

/**
 *
 * @author LinhNhi
 */
public class KetNoi {
    public static Connection ketnoi() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsanpham","root","");
        return c;
    }
}

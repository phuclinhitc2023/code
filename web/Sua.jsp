<%-- 
    Document   : Sua
    Created on : Dec 8, 2024, 12:31:02 PM
    Author     : LinhNhi
--%>

<%@page import="ChuKhanhLinh.KetNoi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="XLSua" method="POST">
            <table>
                <tr>
                    <td><label for="Ma">Mã san phẩm</label></td>
                    <td><input type="text" name="Ma"></td>
                </tr>
                <tr>
                    <td><label for="Ten">Tên sản phẩm</label></td>
                    <td><input type ="text" name="Ten" ></td>
                </tr>
                <tr>
                    <td><label for ="SL">Số lượng</label></td>
                    <td><input type="text" name="SL"></td>
                </tr>
                <tr>
                    <td><label for="Gia">Đơn giá</label></td>
                    <td><input type="text" name="Gia"></td>
                </tr>  
            </table>
            <button type="submit"> Sửa </button>
        </form>
        
        <h3>
            <%=request.getAttribute("thongbao") != null ? request.getAttribute("thongbao"): "" %>
        </h3>
        
        <h1>Quản ký thuê phòng</h1>
        <table>
            <tr>
                <td>Mã sinh viên</td>
                <td>Tên sinh viên</td>
                <td>Ngày sinh</td>
                <td>Điểm trung bình </td>
            </tr>
           
            <%
                Connection conn = KetNoi.ketnoi();
                String laydl = "Select * from sanpham";
                Statement stm = conn.createStatement(); // thực thi câu lệnh sql
                ResultSet rs = stm.executeQuery(laydl); // chưa kết quả
                //lặp
                while (rs.next()){                
            %>          
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
            </tr>
            <%
                }
                rs.close();
                conn.close();
                stm.close();
            %>
        </table>
    </body>
</html>

<%-- 
    Document   : Them
    Created on : Dec 7, 2024, 7:39:14 PM
    Author     : LinhNhi
--%>

<%@page import="ChuKhanhLinh.KetNoi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="XLThem" method="POST">
            <table>              
                <tr>
                    <td> <label for ="Ma"> Mã sản phẩm </label></td>
                    <td><input type="text" name="Ma" required></td>
                </tr>
                <tr>
                    <td><label for="Ten"> Tên sản phẩm </label></td>
                    <td><input type="text" name="Ten" required></td>
                </tr>
                <tr>
                    <td><label for="sl"> Số lượng </label></td>
                    <td><input type="text" name="sl" required></td>
                </tr>
                <tr>
                    <td><label for="Gia"> Đơn giá </label></td>
                    <td><input type="text" name="Gia" required></td>
                </tr>             
                <tr>
                    <td><button type="submit" > Thêm </button></td>
                </tr>
            </table>
        </form>        

        <h1>Quản lý thuê phòng</h1>
        
        <h5> <%=request.getAttribute("thongbao")!=null ? request.getAttribute("thongbao"): ""%></h5> 
        
        <table>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
            </tr>
            <%
                Connection conn = KetNoi.ketnoi();
                String laydl ="Select * from sanpham";
                Statement sta = conn.createStatement(); // thực thi câu lẹnh sql 
                ResultSet rs = sta.executeQuery(laydl); // chứa kq
                while (rs.next()) 
                {
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
            </tr>
            
            <%
                }
                sta.close();
                rs.close();
                conn.close();
            %>
        </table>
    </body>
</html>

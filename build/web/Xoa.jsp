<%-- 
    Document   : Xoa
    Created on : Dec 8, 2024, 3:23:35 PM
    Author     : LinhNhi
--%>

<%@page import="ChuKhanhLinh.KetNoi"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="XLXoa" method="POST">
            <label for ="Ma">Mã phòng</label>
            <input type="text" name="Ma" required/>
            <button type="submit">Xóa</button>
        </form>
        
        <h1>Xóa sản phẩm</h1>
        <h5><%=request.getAttribute("thongbao")!=null ?request.getAttribute("thongbao"):""%></h5>
        <table>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Mã khách hàng</th>
                <th>Ngày đến</th>
                <th>Ngày đi</th>
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

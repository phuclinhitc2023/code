<%-- 
    Document   : TimKiem
    Created on : Dec 10, 2024, 9:05:44 AM
    Author     : LinhNhi
--%>

<%@page import="ChuKhanhLinh.SanPham"%>
<%@page import="ChuKhanhLinh.KetNoi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello World!</h1>
         <form action="XLTimkiem" method="POST">
            <label for="Masp">Mã sản phẩm:</label>
            <input type="text" name="Masp"/>

            <button type="submit">Tìm kiếm</button>
        </form>
            <h5><%=request.getAttribute("thongbao") != null ? request.getAttribute("thongbao") : ""%></h5>
        <table>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm </th>
            <th>Số lượng </th>
            <th>Đơn giá </th>
            <th>Chiết khấu</th>
                
        <%
            //ArrayList<sanpham> sp = (ArrayList<sanpham>) request.getAttribute("sanpham");
            ArrayList<SanPham> sp = (ArrayList<SanPham>) request.getAttribute("sanpham");
            if(sp==null){            
            Connection kn = KetNoi.ketnoi();
            String laydl ="Select * from sanpham";
            Statement stm = kn.createStatement();
            ResultSet rs = stm.executeQuery(laydl);
            while(rs.next()){
            %>
              <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getInt(3)%></td>
                <td><%=rs.getFloat(4)%></td>
                <td><%=
                     rs.getInt(3)>5 && rs.getInt(3)<=10 ? 0.05*rs.getInt(3)*rs.getFloat(4): rs.getInt(3)>10 ? 0.1*rs.getInt(3)*rs.getFloat(4):"Không được chiết khấu"
                %></td>
            </tr>
        <%
     
                } 
                rs.close();
                stm.close();
                kn.close();
            }else {
                for (SanPham a: sp){
                    %>
                    <tr>
                <td><%=a.getMa()%></td>
                <td><%=a.getTen()%></td>
                <td><%=a.getSl()%></td>
                <td><%=a.getDg()%></td>
                <td><%=                    a.getSl()>5 && a.getSl()<=10 ? 0.05*a.getSl()*a.getDg(): a.getSl()>10 ? 0.1*a.getSl()*a.getDg():"Không được chiết khấu"
%></td>
            </tr>
        <%
                }
          }
        %>
    </table>
    </body>
    
</html>

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ChuKhanhLinh;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LinhNhi
 */
@WebServlet(name = "XLTimkiem", urlPatterns = {"/XLTimkiem"})
public class XLTimkiem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet XLTimkiem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XLTimkiem at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        try {
            //        processRequest(request, response);
            String masp = request.getParameter("Masp");
            if (masp == "") {
                request.getRequestDispatcher("TimKiem.jsp").forward(request, response);
            } else {
                String tb = "";
                ArrayList<SanPham> tp = new ArrayList<>();
                Connection conn = KetNoi.ketnoi();
                Statement stm = conn.createStatement();
                String timkiemsql = "Select * from sanpham where MaSP = '" + masp + "'";
                ResultSet rs = stm.executeQuery(timkiemsql);
                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        SanPham a = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
                        tp.add(a);
                    }
                    tb = "Tìm thành công mã sản phẩm: " + masp;
                } else {
                    tb = "Không có sản phẩm nào!!!";
                }

                request.setAttribute("thongbao", tb);
                request.setAttribute("sanpham", tp);
                request.getRequestDispatcher("TimKiem.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XLTimkiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(XLTimkiem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

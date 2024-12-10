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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LinhNhi
 */
@WebServlet(name = "XLThem", urlPatterns = {"/XLThem"})
public class XLThem extends HttpServlet {

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
            out.println("<title>Servlet XLThem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XLThem at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String ma = request.getParameter("Ma"); //"Ma" phải giống Them.jsp
        String ten = request.getParameter("Ten");
        String sl = request.getParameter("sl");
        String gia = request.getParameter("Gia");
        String tb = "";       

        try {
            Connection conn = KetNoi.ketnoi();
            Statement stm = conn.createStatement();
            String kt = "Select * from sanpham where MaSP='" + ma + "' "; //MaSP giống DataBase
            ResultSet rs = stm.executeQuery(kt);
            if (rs.next()) {
                tb = "Trùng mã";
            } else {
                String themsql = "insert into sanpham values ('" + ma + "','" + ten + "','" + sl + "','" + gia + "')"; // ma giống khai báo XLThem
                stm.executeUpdate(themsql);
                tb="Thêm thành công mã phòng: "+ma;
            }

            request.setAttribute("thongbao", tb);
            request.getRequestDispatcher("Them.jsp").forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XLThem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(XLThem.class.getName()).log(Level.SEVERE, null, ex);
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

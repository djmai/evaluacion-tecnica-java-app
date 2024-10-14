/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import Service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
public class LoginController extends HttpServlet {

    private UsuarioService usuarioService;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioService = new UsuarioService();
        usuarioDAO = new UsuarioDAO();
    }

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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

        // Establecer el título de la página
        request.setAttribute("pageTitle", "Login");

        String action = request.getServletPath();

        if (action.equals("/logout")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Cerrar sesión
            }
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
        dispatcher.forward(request, response);
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
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        Usuario usuario = usuarioService.autenticarUsuario(correo, contrasena);
        if (usuario != null) {
            // Guardar información del usuario en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Obtener los permisos del usuario
            List<String> permisos = usuarioDAO.obtenerPermisos(usuario.getId());

            // Guardar los permisos en la sesión (o en el request si solo es para esta página)
            session.setAttribute("permisos", permisos);

            response.sendRedirect(request.getContextPath() + "/inicio"); // Cambiar a la ruta de inicio
        } else {
            request.setAttribute("error", "Credenciales incorrectas");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
            dispatcher.forward(request, response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Usuario;
import Service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService;

    @Override
    public void init() {
        usuarioService = new UsuarioService();
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
            out.println("<title>Servlet UsuarioController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
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

        request.setAttribute("pageTitle", "Usuarios");

        String action = request.getServletPath();

        if (action.equals("/altaUsuario")) {
            request.setAttribute("pageTitle", "Alta Usuario");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuarios/altaUsuario.jsp");
            dispatcher.forward(request, response);
        }

        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuarios/administrarUsuarios.jsp");
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
        String action = request.getServletPath();

        if (action.equals("/altaUsuario")) {
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("contrasena");
            String rol = request.getParameter("rol");

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            usuario.setIdRol(Integer.parseInt(rol));

            boolean exito = usuarioService.registrarUsuario(usuario);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/usuarios");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error al registrar el usuario.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuarios/altaUsuario.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (action.equals("/eliminarUsuario")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String estatus = request.getParameter("estatus");

            boolean exito = usuarioService.eliminarUsuario(id, estatus);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/usuarios");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error al eliminar el usuario.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/productos.jsp");
                dispatcher.forward(request, response);
            }
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

    // Eliminar un usuario
    /*protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usuarioService.eliminarUsuario(id);
        response.sendRedirect(request.getContextPath() + "/usuarios");
    }*/
}

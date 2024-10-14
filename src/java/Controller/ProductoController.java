/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Movimiento;
import Model.Producto;
import Model.UsuarioDAO;
import Service.MovimientoService;
import Service.ProductoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
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
public class ProductoController extends HttpServlet {

    private ProductoService productoService;
    private MovimientoService movimientoService;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        productoService = new ProductoService();
        movimientoService = new MovimientoService();
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
            out.println("<title>Servlet ProductoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
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

        request.setAttribute("pageTitle", "Productos");

        HttpSession session = request.getSession(false); // false para no crear una nueva sesión si no existe
        List<String> permisos = (List<String>) session.getAttribute("permisos");

        String action = request.getServletPath();

        if (action.equals("/agregarProducto") && permisos.contains("Agregar nuevos productos")) {
            // Establecer el título de la página
            request.setAttribute("pageTitle", "Agregar Producto");

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/altaProducto.jsp");
            dispatcher.forward(request, response);
        }

        if (action.equals("/editarInventario") && permisos.contains("Aumentar inventario")) {
            request.setAttribute("pageTitle", "Entradas de Inventario");

            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = productoService.obtenerProductoPorId(id); // Método para obtener la información del producto

            request.setAttribute("producto", producto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/entradaInventario.jsp");
            dispatcher.forward(request, response);
        }

        if (action.equals("/editarSalidaInventario") && permisos.contains("Ver módulo para Salida de productos")) {
            request.setAttribute("pageTitle", "Salidas de Inventario");

            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = productoService.obtenerProductoPorId(id);

            request.setAttribute("producto", producto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/salidaInventario.jsp");
            dispatcher.forward(request, response);
        }

        if (action.equals("/movimientos") && permisos.contains("Ver módulo del histórico")) {

            request.setAttribute("pageTitle", "Movimientos de Inventario");

            String tipoMovimiento = request.getParameter("tipo_movimiento");
            List<Movimiento> movimientos = movimientoService.listarMovimientos(tipoMovimiento);

            request.setAttribute("listaMovimientos", movimientos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/historialMovimientos.jsp");
            dispatcher.forward(request, response);
        }

        //processRequest(request, response);
        List<Producto> productos = productoService.listarProductos();
        if (productos == null) {
            productos = new ArrayList<>(); // Inicializa la lista si es null
        }
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("views/productos/productos.jsp").forward(request, response);
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
        HttpSession session = request.getSession(false); // false para no crear una nueva sesión si no existe
        List<String> permisos = (List<String>) session.getAttribute("permisos");

        if (action.equals("/agregarProducto") && permisos.contains("Agregar nuevos productos")) {
            String nombreProducto = request.getParameter("nombre_producto");
            String descripcionProducto = request.getParameter("descripcion_producto");
            //int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int cantidad = 0;
            //String estatus = request.getParameter("estatus");
            String estatus = "1";

            Producto nuevoProducto = new Producto(0, nombreProducto, descripcionProducto, cantidad, estatus);
            boolean exito = productoService.agregarProducto(nuevoProducto);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/productos");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error al registrar el producto.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/altaProducto.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (action.equals("/actualizarEstatus") && permisos.contains("Dar de baja/reactivar un producto")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String estatus = request.getParameter("estatus");

            boolean exito = productoService.actualizarEstatus(id, estatus);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/productos");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error al actualizar el estatus.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/productos.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (action.equals("/actualizarInventario") && permisos.contains("Aumentar inventario")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int cantidadNueva = Integer.parseInt(request.getParameter("cantidad_nueva"));
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

            boolean exito = productoService.actualizarInventario(id, cantidadNueva, id_usuario);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/productos");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error: No se puede reducir la cantidad de inventario.");
                Producto producto = productoService.obtenerProductoPorId(id); // Recargar producto para el formulario
                request.setAttribute("producto", producto);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/entradaInventario.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (action.equals("/actualizarSalidaInventario") && permisos.contains("Sacar inventario del almacén")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int cantidadSalida = Integer.parseInt(request.getParameter("cantidad_salida"));
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

            boolean exito = productoService.sacarDelInventario(id, cantidadSalida, id_usuario);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/productos");  // Redirige a la lista de productos
            } else {
                request.setAttribute("errorMessage", "Error: No puedes sacar más cantidad de la disponible.");
                Producto producto = productoService.obtenerProductoPorId(id); // Recargar producto para el formulario
                request.setAttribute("producto", producto);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/productos/salidaInventario.jsp");
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

}

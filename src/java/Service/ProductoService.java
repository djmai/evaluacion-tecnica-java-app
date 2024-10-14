/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
import Config.DatabaseConnection;
import Model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class ProductoService {

    DatabaseConnection cn = new DatabaseConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet resultSet;

    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";  // Asegúrate de que la tabla 'productos' existe en tu base de datos

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_producto");
                String nombre = resultSet.getString("nombre_producto");
                String descripcion = resultSet.getString("descripcion_producto");
                int cantidad = resultSet.getInt("cantidad");
                String estatus = resultSet.getString("estatus");
                productos.add(new Producto(id, nombre, descripcion, cantidad, estatus));
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    // Método para agregar un producto a la base de datos
    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre_producto, descripcion_producto, cantidad, estatus) VALUES (?, ?, ?, ?)";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            /*statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, 0);*/
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getCantidad());
            statement.setString(4, producto.getEstatus());

            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar el estatus de un producto
    public boolean actualizarEstatus(int id, String estatus) {
        String sql = "UPDATE productos SET estatus = ? WHERE id_producto = ?";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, estatus);
            statement.setInt(2, id);

            int filasActualizadas = statement.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Producto obtenerProductoPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id_producto = ?";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombreProducto = resultSet.getString("nombre_producto");
                String descripcionProducto = resultSet.getString("descripcion_producto");
                int cantidad = resultSet.getInt("cantidad");
                String estatus = resultSet.getString("estatus");

                return new Producto(id, nombreProducto, descripcionProducto, cantidad, estatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para actualizar el inventario de un producto
    public boolean actualizarInventario(int id, int cantidadNueva, int id_usuario) {
        String sqlSelect = "SELECT cantidad FROM productos WHERE id_producto = ?";
        String sqlUpdate = "UPDATE productos SET cantidad = ? WHERE id_producto = ?";
        String sqlInsertMovimiento = "INSERT INTO movimientos (id_producto, id_usuario, tipo_movimiento, cantidad, fecha_hora) VALUES (?, ?, ?, ?, ?)";
        

        try (Connection connection = cn.getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sqlSelect); PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate); PreparedStatement insertMovStatement = connection.prepareStatement(sqlInsertMovimiento);) {

            // Obtener la cantidad actual
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int cantidadActual = resultSet.getInt("cantidad");

                // Validar que no se esté intentando reducir la cantidad
                if (cantidadNueva < 0) {
                    return false; // Intentar disminuir la cantidad, retorna falso
                }

                // Actualizar la cantidad
                int nuevaCantidad = cantidadActual + cantidadNueva;
                updateStatement.setInt(1, nuevaCantidad);
                updateStatement.setInt(2, id);
                int filasActualizadas = updateStatement.executeUpdate();

                // Registrar movimiento
                insertMovStatement.setInt(1, id);
                insertMovStatement.setInt(2, id_usuario);
                insertMovStatement.setString(3, "entrada");
                insertMovStatement.setInt(4, cantidadNueva);
                insertMovStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                filasActualizadas = insertMovStatement.executeUpdate();

                return filasActualizadas > 0;
            }

        } catch (SQLException e) {
            String error = "Error en la inserción: " + e.getMessage();
            System.err.println("Error en la inserción: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Método para sacar productos del inventario
    public boolean sacarDelInventario(int id, int cantidadSalida, int id_usuario) {
        String sqlSelect = "SELECT cantidad FROM productos WHERE id_producto = ?";
        String sqlUpdate = "UPDATE productos SET cantidad = ? WHERE id_producto = ?";
        String sqlInsertMovimiento = "INSERT INTO movimientos (id_producto, id_usuario, tipo_movimiento, cantidad, fecha_hora) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = cn.getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sqlSelect); PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate); PreparedStatement insertMovStatement = connection.prepareStatement(sqlInsertMovimiento)) {

            // Obtener la cantidad actual
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int cantidadActual = resultSet.getInt("cantidad");

                // Validar que no se intente sacar más de la cantidad disponible
                if (cantidadSalida > cantidadActual || cantidadSalida < 0) {
                    return false;  // Intento de sacar más de lo disponible, retorna falso
                }

                // Actualizar la cantidad después de la salida
                int nuevaCantidad = cantidadActual - cantidadSalida;
                updateStatement.setInt(1, nuevaCantidad);
                updateStatement.setInt(2, id);
                int filasActualizadas = updateStatement.executeUpdate();

                // Registrar movimiento
                insertMovStatement.setInt(1, id);
                insertMovStatement.setInt(2, id_usuario);
                insertMovStatement.setString(3, "salida");
                insertMovStatement.setInt(4, cantidadSalida);
                insertMovStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                filasActualizadas = insertMovStatement.executeUpdate();

                return filasActualizadas > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Producto> listarProductosActivos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE estatus = 'ACTIVO'";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre_producto"));
                producto.setDescripcion(resultSet.getString("descripcion_producto"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setEstatus(resultSet.getString("estatus"));

                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

}

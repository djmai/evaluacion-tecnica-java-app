/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Config.DatabaseConnection;
import Model.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
public class MovimientoService {

    DatabaseConnection cn = new DatabaseConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet resultSet;

    // Método para listar movimientos, con opción de filtro por tipo
    public List<Movimiento> listarMovimientos(String tipoMovimiento) {
        List<Movimiento> movimientos = new ArrayList<>();
        // String sql = "SELECT * FROM movimientos";
        
        String sql = "SELECT m.*, p.nombre_producto, u.nombre as nombre_usuario "
                + "FROM movimientos m "
                + "JOIN productos p ON m.id_producto = p.id_producto "
                + "JOIN usuarios u ON m.id_usuario = u.idUsuario";

        if (tipoMovimiento != null && !tipoMovimiento.isEmpty()) {
            sql += " WHERE tipo_movimiento = ?";
        }

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            if (tipoMovimiento != null && !tipoMovimiento.isEmpty()) {
                statement.setString(1, tipoMovimiento);
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setId(resultSet.getInt("id_movimiento"));
                movimiento.setIdProducto(resultSet.getInt("id_producto"));
                movimiento.setIdUsuario(resultSet.getInt("id_usuario"));
                movimiento.setTipoMovimiento(resultSet.getString("tipo_movimiento"));
                movimiento.setCantidad(resultSet.getInt("cantidad"));
                movimiento.setFechaHora(resultSet.getTimestamp("fecha_hora"));
                movimiento.setDescripcionProducto(resultSet.getString("nombre_producto"));
                movimiento.setNombreUsuario(resultSet.getString("nombre_usuario"));

                movimientos.add(movimiento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movimientos;
    }

    // Método para registrar un nuevo movimiento
    public void registrarMovimiento(Movimiento movimiento) {
        String sql = "INSERT INTO movimientos (tipo_movimiento, producto_id, cantidad, usuario) VALUES (?, ?, ?, ?)";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, movimiento.getTipoMovimiento());
            statement.setInt(2, movimiento.getIdProducto());
            statement.setInt(3, movimiento.getCantidad());
            statement.setInt(4, movimiento.getIdUsuario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

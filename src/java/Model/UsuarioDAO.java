/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.DatabaseConnection;
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
public class UsuarioDAO {

    DatabaseConnection cn = new DatabaseConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<String> obtenerPermisos(int idUsuario) {
        List<String> permisos = new ArrayList<>();

        String sql = "SELECT p.descripcion "
                + "FROM rol_permisos rp "
                + "JOIN permisos p ON p.idPermiso = rp.idPermiso "
                + "WHERE rp.idRol = (SELECT idRol FROM usuarios WHERE idUsuario = ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                permisos.add(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener permisos: " + e.getMessage());
            e.printStackTrace();
        }

        return permisos;
    }

}

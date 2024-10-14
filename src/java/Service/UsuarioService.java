/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Config.DatabaseConnection;
import Model.Rol;
import Model.Usuario;
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
public class UsuarioService {

    DatabaseConnection cn = new DatabaseConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet resultSet;

    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasena, idRol, estatus) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getContrasena());
            statement.setInt(4, usuario.getIdRol());
            statement.setString(5, "activo");
            //statement.executeUpdate();

            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        //String sql = "SELECT * FROM usuarios";
        String sql = "SELECT u.*, r.nombreRol FROM usuarios u JOIN roles r ON u.idRol = r.idRol";

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setContrasena(resultSet.getString("contrasena"));
                usuario.setIdRol(resultSet.getInt("idRol"));
                usuario.setEstatus(resultSet.getString("estatus"));

                Rol rol = new Rol(resultSet.getInt("idRol"), resultSet.getString("nombreRol"));
                usuario.setRol(rol);

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(int id, String estatus) {
        String sql = "UPDATE usuarios SET estatus = ? WHERE idUsuario = ?";

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

    // Método para autenticar un usuario
    public Usuario autenticarUsuario(String correo, String contrasena) {
        //String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
        String sql = "SELECT u.*, r.nombreRol FROM usuarios u JOIN roles r ON u.idRol = r.idRol WHERE correo = ? AND contrasena = ?";
        Usuario usuario = null;

        try (Connection connection = cn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setIdRol(resultSet.getInt("idRol"));
                usuario.setEstatus(resultSet.getString("estatus"));
                
                Rol rol = new Rol(resultSet.getInt("idRol"), resultSet.getString("nombreRol"));
                usuario.setRol(rol);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.Usuario;
import model.DatabaseConnection;

/**
 *
 * @author gcardenas
 */
public class UsuarioDAO {
    
       // Método para obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("Id_Usuario"));
                usuario.setIdentificacion(rs.getInt("Identificacion"));
                usuario.setIdTipoIdentificacion(rs.getInt("Id_Tipo_Identificacion"));
                usuario.setIdCargo(rs.getInt("Id_Cargo"));
                usuario.setNombre1(rs.getString("Nombre_1"));
                usuario.setNombre2(rs.getString("Nombre_2"));
                usuario.setApellido1(rs.getString("Apellido_1"));
                usuario.setApellido2(rs.getString("Apellido_2"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setEstado(rs.getBoolean("Estado"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setFechaRegistro(rs.getTimestamp("Fecha_Registro"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }
    
    
    // Método para obtener un usuario por su ID
    public Usuario getUsuarioById(int id) {
        String sql = "SELECT * FROM Usuario WHERE Id_Usuario = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("Id_Usuario"));
                usuario.setIdentificacion(rs.getInt("Identificacion"));
                usuario.setIdTipoIdentificacion(rs.getInt("Id_Tipo_Identificacion"));
                usuario.setIdCargo(rs.getInt("Id_Cargo"));
                usuario.setNombre1(rs.getString("Nombre_1"));
                usuario.setNombre2(rs.getString("Nombre_2"));
                usuario.setApellido1(rs.getString("Apellido_1"));
                usuario.setApellido2(rs.getString("Apellido_2"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setEstado(rs.getBoolean("Estado"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setFechaRegistro(rs.getTimestamp("Fecha_Registro"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    // Método para actualizar un usuario
    public boolean updateUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET Identificacion = ?, Id_Tipo_Identificacion = ?, Id_Cargo = ?, Nombre_1 = ?, Nombre_2 = ?, Apellido_1 = ?, Apellido_2 = ?, Domicilio = ?, Telefono = ?, Email = ?, Estado = ?, Password = ?, Fecha_Registro = ? WHERE Id_Usuario = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, usuario.getIdentificacion());
            pstmt.setInt(2, usuario.getIdTipoIdentificacion());
            pstmt.setInt(3, usuario.getIdCargo());
            pstmt.setString(4, usuario.getNombre1());
            pstmt.setString(5, usuario.getNombre2());
            pstmt.setString(6, usuario.getApellido1());
            pstmt.setString(7, usuario.getApellido2());
            pstmt.setString(8, usuario.getDomicilio());
            pstmt.setString(9, usuario.getTelefono());
            pstmt.setString(10, usuario.getEmail());
            pstmt.setBoolean(11, usuario.isEstado());
            pstmt.setString(12, usuario.getPassword());
            pstmt.setTimestamp(13, new Timestamp(usuario.getFechaRegistro().getTime()));
            pstmt.setInt(14, usuario.getIdUsuario());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Usuario getUsuarioByEmailAndPassword(String identificacion, String password) {
        String sql = "SELECT * FROM Usuario WHERE Identificacion = ? AND Password = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, identificacion);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("Id_Usuario"));
                usuario.setIdentificacion(rs.getInt("Identificacion"));
                usuario.setIdTipoIdentificacion(rs.getInt("Id_Tipo_Identificacion"));
                usuario.setIdCargo(rs.getInt("Id_Cargo"));
                usuario.setNombre1(rs.getString("Nombre_1"));
                usuario.setNombre2(rs.getString("Nombre_2"));
                usuario.setApellido1(rs.getString("Apellido_1"));
                usuario.setApellido2(rs.getString("Apellido_2"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setEstado(rs.getBoolean("Estado"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setFechaRegistro(rs.getTimestamp("Fecha_Registro"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
}

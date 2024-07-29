/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.Cliente;
import model.DatabaseConnection;
import java.util.*;

/**
 *
 * @author gcardenas
 */
public class ClienteDAO {

    // Método para obtener todos los clientes
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setid_Cliente(rs.getInt("id_Cliente"));
                cliente.setIdentificacion(rs.getInt("identificacion"));
                cliente.setIdTipoIdentificacion(rs.getInt("id_Tipo_Identificacion"));
                cliente.setNombre1(rs.getString("nombre_1"));
                cliente.setNombre_2(rs.getString("nombre_2"));
                cliente.setApellido1(rs.getString("apellido_1"));
                cliente.setApellido2(rs.getString("apellido_2"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEstado(rs.getBoolean("estado"));
                cliente.setFechaRegistro(rs.getDate("fecha_Registro"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para obtener un cliente por su ID
    public Cliente getClienteById(int id_Cliente) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE id_Cliente = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_Cliente);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setid_Cliente(rs.getInt("id_Cliente"));
                cliente.setIdentificacion(rs.getInt("identificacion"));
                cliente.setIdTipoIdentificacion(rs.getInt("id_Tipo_Identificacion"));
                cliente.setNombre1(rs.getString("nombre_1"));
                cliente.setNombre_2(rs.getString("nombre_2"));
                cliente.setApellido1(rs.getString("apellido_1"));
                cliente.setApellido2(rs.getString("apellido_2"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEstado(rs.getBoolean("estado"));
                cliente.setFechaRegistro(rs.getDate("fecha_Registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // Método para agregar un nuevo cliente
    public boolean addCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (identificacion, id_Tipo_Identificacion, nombre_1, nombre_2, apellido_1, apellido_2, domicilio, telefono, email, estado, fecha_Registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getIdentificacion());
            pstmt.setInt(2, cliente.getIdTipoIdentificacion());
            pstmt.setString(3, cliente.getNombre1());
            pstmt.setString(4, cliente.getNombre_2());
            pstmt.setString(5, cliente.getApellido_1());
            pstmt.setString(6, cliente.getApellido_2());
            pstmt.setString(7, cliente.getDomicilio());
            pstmt.setString(8, cliente.getTelefono());
            pstmt.setString(9, cliente.getEmail());
            pstmt.setBoolean(10, cliente.isEstado());
            pstmt.setDate(11, new java.sql.Date(cliente.getfecha_Registro().getTime()));

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar un cliente existente
    public boolean updateCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET identificacion = ?, id_Tipo_Identificacion = ?, nombre_1 = ?, nombre_2 = ?, apellido_1 = ?, apellido_2 = ?, domicilio = ?, telefono = ?, email = ?, estado = ?, fecha_Registro = ? WHERE id_Cliente = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getIdentificacion());
            pstmt.setInt(2, cliente.getIdTipoIdentificacion());
            pstmt.setString(3, cliente.getNombre1());
            pstmt.setString(4, cliente.getNombre_2());
            pstmt.setString(5, cliente.getApellido_1());
            pstmt.setString(6, cliente.getApellido_2());
            pstmt.setString(7, cliente.getDomicilio());
            pstmt.setString(8, cliente.getTelefono());
            pstmt.setString(9, cliente.getEmail());
            pstmt.setBoolean(10, cliente.isEstado());
            pstmt.setDate(11, new java.sql.Date(cliente.getfecha_Registro().getTime()));
            pstmt.setInt(12, cliente.getid_Cliente());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un cliente por su ID
    public boolean deleteCliente(int id_Cliente) {
        String sql = "DELETE FROM Cliente WHERE id_Cliente = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_Cliente);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
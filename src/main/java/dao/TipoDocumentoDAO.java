/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.DatabaseConnection;
import model.TipoDocumento;
import java.util.*;


/**
 *
 * @author gcardenas
 */
public class TipoDocumentoDAO {

    // Método para obtener todos los tipos de documentos
    public List<TipoDocumento> getAllTipoDocumentos() {
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        String sql = "SELECT * FROM Tipo_Documento";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setIdTipoDocumento(rs.getInt("Id_Tipo_Documento"));
                tipoDocumento.setDescripcion(rs.getString("Descripcion"));
                tipoDocumento.setEstado(rs.getBoolean("Estado"));

                tipoDocumentos.add(tipoDocumento);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tipoDocumentos;
    }

    // Método para obtener un tipo de documento por su ID
    public TipoDocumento getTipoDocumentoById(int id) {
        String sql = "SELECT * FROM Tipo_Documento WHERE Id_Tipo_Documento = ?";
        TipoDocumento tipoDocumento = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                tipoDocumento = new TipoDocumento();
                tipoDocumento.setIdTipoDocumento(rs.getInt("Id_Tipo_Documento"));
                tipoDocumento.setDescripcion(rs.getString("Descripcion"));
                tipoDocumento.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tipoDocumento;
    }

    // Método para actualizar un tipo de documento
    public boolean updateTipoDocumento(TipoDocumento tipoDocumento) {
        String sql = "UPDATE Tipo_Documento SET Descripcion = ?, Estado = ? WHERE Id_Tipo_Documento = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipoDocumento.getDescripcion());
            pstmt.setBoolean(2, tipoDocumento.isEstado());
            pstmt.setInt(3, tipoDocumento.getIdTipoDocumento());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Método para eliminar un tipo de documento
    public boolean deleteTipoDocumento(int id) {
        String sql = "DELETE FROM Tipo_Documento WHERE Id_Tipo_Documento = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Cargo;
import model.DatabaseConnection;
/**
 *
 * @author gcardenas
 */
public class CargoDAO {
    //Metodo que obtiene todos los campos
    public List<Cargo> getCargos()
    {
        List<Cargo> cargos = new ArrayList<>();
        String sql = "Select * From Cargos";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) 
            {
                Cargo cargo = new Cargo();
                
                cargo.setIdCargo(rs.getInt("Id_Cargo"));
                cargo.setDescripcion(rs.getString("Eescripcion"));
                cargo.setEstado(rs.getBoolean("Estado"));
                
                
            }
        }catch(SQLException e){
            System.out.println("model.CargoDAO.getCargos() ah ocurrido un error al obtener todos os registros de Cargos");
        }
        
        return cargos;
    }
    //Metodo que ingresa un nuevo cargo
    public boolean addCargo(Cargo cargo)
    {
        String sql = "INSERT INTO Cargo (Descripcion, Estado) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cargo.getDescripcion());
            pstmt.setBoolean(2, cargo.isEstado());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     // Método para obtener un cargo por su ID
    public Cargo getCargoById(int id) {
        String sql = "SELECT * FROM Cargo WHERE Id_Cargo = ?";
        Cargo cargo = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("Id_Cargo"));
                cargo.setDescripcion(rs.getString("Descripcion"));
                cargo.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cargo;
    }
    
    // Método para actualizar un cargo
    public boolean updateCargo(Cargo cargo) {
        String sql = "UPDATE Cargo SET Descripcion = ?, Estado = ? WHERE Id_Cargo = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cargo.getDescripcion());
            pstmt.setBoolean(2, cargo.isEstado());
            pstmt.setInt(3, cargo.getIdCargo());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    // Método para eliminar un cargo
    public boolean deleteCargo(int id) {
        String sql = "DELETE FROM Cargo WHERE Id_Cargo = ?";

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
    
    // Método para eliminar un cliente
    public boolean deleteCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE Identificacion = ?";

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

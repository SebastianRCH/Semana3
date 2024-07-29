/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gcardenas
 */
public class Cargo {
    
    private int Id_Cargo;
    private String Descripcion;
    private boolean Estado;

    // Getters y Setters
    public int getIdCargo() {
        return Id_Cargo;
    }

    public void setIdCargo(int idCargo) {
        this.Id_Cargo = idCargo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }
}

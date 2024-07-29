/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author gcardenas
 */
public class Cliente {
    
    private int id_Cliente;
    private int identificacion;
    private int id_Tipo_Identificacion;
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    private String domicilio;
    private String telefono;
    private String email;
    private boolean estado;
    private Date fecha_Registro;

    // Getters y Setters
    public int getid_Cliente() {
        return id_Cliente;
    }

    public void setid_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdTipoIdentificacion() {
        return id_Tipo_Identificacion;
    }

    public void setIdTipoIdentificacion(int id_Tipo_Identificacion) {
        this.id_Tipo_Identificacion = id_Tipo_Identificacion;
    }

    public String getNombre1() {
        return nombre_1;
    }

    public void setNombre1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getfecha_Registro() {
        return fecha_Registro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fecha_Registro = fechaRegistro;
    }
    
    
    
}

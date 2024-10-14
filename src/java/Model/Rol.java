/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Miguel Martinez <mmartinezdev.com>
 */
public class Rol {

    private int id;
    private String descripcion;  // Este campo es la descripción del rol, no el ID

    public Rol() {

    }

    // Constructor, getters y setters
    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

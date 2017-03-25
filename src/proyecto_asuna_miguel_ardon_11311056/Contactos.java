/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_asuna_miguel_ardon_11311056;

import java.awt.Image;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Contactos {
    int id;
    String nombre;
    String numero;
    String imagen;

    public Contactos() {
    }

    public Contactos(int id, String nombre, String numero, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Contactos{" + "id=" + id + ", nombre=" + nombre + ", numero=" + numero + ", imagen=" + imagen + '}';
    }    
}
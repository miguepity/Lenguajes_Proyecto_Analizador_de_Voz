/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_asuna_miguel_ardon_11311056;

import proyecto_asuna_miguel_ardon_11311056.Contactos;
import java.util.ArrayList;

/**
 *
 * @author Miguel A. Ardon E
 */
public class Usuario {
    int id;
    String nombre;
    String password;
    ArrayList<Contactos> contactos;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String password, ArrayList<Contactos> contactos) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.contactos = contactos;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contactos> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", contactos=" + contactos + '}';
    }
}

package com.proyectofinal.modelo;

import com.proyectofinal.interfaces.vendible;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto  implements vendible {

    @Id
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;


    // Constructor vacío necesario para Hibernate
    public Producto() {
    }


    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public String getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public double getPrecio() {
        return precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public void mostrarInformacion() {

        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);

    }
}
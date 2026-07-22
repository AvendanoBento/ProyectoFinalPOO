package com.proyectofinal.servicio;

import com.proyectofinal.dao.ProductoDAO;
import com.proyectofinal.modelo.Producto;

import java.util.List;

public class Inventario {

    private ProductoDAO productoDAO;


    public Inventario() {
        productoDAO = new ProductoDAO();
    }


    // Registrar producto
    public void agregarProducto(Producto producto) {

        productoDAO.guardar(producto);

        System.out.println("Producto registrado correctamente.");
    }


    // Mostrar productos
    public void mostrarProductos() {

        List<Producto> productos = productoDAO.listar();


        if(productos.isEmpty()) {

            System.out.println("No hay productos registrados.");

            return;
        }


        System.out.println("\n===== LISTA DE PRODUCTOS =====");


        for(Producto producto : productos) {

            producto.mostrarInformacion();

        }
    }


    // Buscar producto
    public void buscarProducto(String codigo) {

        List<Producto> productos = productoDAO.listar();


        for(Producto producto : productos) {


            if(producto.getCodigo().equals(codigo)) {

                System.out.println("Producto encontrado:");

                producto.mostrarInformacion();

                return;
            }

        }


        System.out.println("Producto no encontrado.");
    }



    // Eliminar producto
    public boolean eliminarProducto(String codigo) {

        productoDAO.eliminar(codigo);

        return true;
    }
    // Actualizar producto
public void actualizarProducto(Producto producto) {

    Producto existente = productoDAO.buscar(producto.getCodigo());

    if (existente != null) {

        productoDAO.actualizar(producto);

        System.out.println("Producto actualizado correctamente.");

    } else {

        System.out.println("No existe el producto.");

    }

}

}
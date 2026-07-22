package com.proyectofinal;

import com.proyectofinal.modelo.Producto;
import com.proyectofinal.servicio.Inventario;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventario inventario = new Inventario();

        int opcion;


        do {

            System.out.println("\n==========================");
            System.out.println("     SISTEMA DE TIENDA");
            System.out.println("==========================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();


            switch(opcion) {


                case 1:

                    sc.nextLine();

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine().trim().toUpperCase();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim().toUpperCase();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    precio = Math.round(precio * 100.0) / 100.0;

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();


                    Producto producto = new Producto(
                            codigo,
                            nombre,
                            precio,
                            cantidad
                    );


                    inventario.agregarProducto(producto);

                    break;



                case 2:

                    inventario.mostrarProductos();

                    break;



                case 3:

                    sc.nextLine();

                    System.out.print("Codigo del producto: ");
                    codigo = sc.nextLine().trim().toUpperCase();

                    inventario.buscarProducto(codigo);

                    break;



                case 4:

                    sc.nextLine();

                    System.out.print("Codigo: ");
                    codigo = sc.nextLine().trim().toUpperCase();

                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine().trim().toUpperCase();

                    System.out.print("Nuevo precio: ");
                    precio = sc.nextDouble();
                    precio = Math.round(precio * 100.0) / 100.0;

                    System.out.print("Nueva cantidad: ");
                    cantidad = sc.nextInt();


                    Producto productoActualizar = new Producto(
                            codigo,
                            nombre,
                            precio,
                            cantidad
                    );


                    inventario.actualizarProducto(productoActualizar);

                    break;



                case 5:

                    sc.nextLine();

                    System.out.print("Codigo a eliminar: ");
                    codigo = sc.nextLine().trim().toUpperCase();

                    inventario.eliminarProducto(codigo);

                    break;



                case 6:

                    System.out.println("Saliendo...");

                    break;



                default:

                    System.out.println("Opcion incorrecta.");

            }


        } while(opcion != 6);


        sc.close();

    }

}
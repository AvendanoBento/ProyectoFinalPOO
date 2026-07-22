package com.proyectofinal.dao;

import com.proyectofinal.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductoDAO {

    private EntityManagerFactory emf;


    public ProductoDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaPU");
    }



    // Agregar producto
    public void guardar(Producto producto) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(producto);

            em.getTransaction().commit();

            System.out.println("Producto guardado en la base de datos.");

        } finally {

            em.close();

        }
    }



    // Listar todos los productos
    public List<Producto> listar() {

        EntityManager em = emf.createEntityManager();

        try {

            return em.createQuery(
                    "SELECT p FROM Producto p",
                    Producto.class
            ).getResultList();


        } finally {

            em.close();

        }
    }



    // Busca producto por codigo
    public Producto buscar(String codigo) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Producto.class, codigo);


        } finally {

            em.close();

        }
    }




    // Actualizar producto
    public void actualizar(Producto producto) {

        EntityManager em = emf.createEntityManager();


        try {

            em.getTransaction().begin();


            em.merge(producto);


            em.getTransaction().commit();


            System.out.println("Producto actualizado en la base de datos.");


        } finally {

            em.close();

        }

    }




    // Eliminar producto
    public void eliminar(String codigo) {

        EntityManager em = emf.createEntityManager();


        try {

            em.getTransaction().begin();


            Producto producto = em.find(Producto.class, codigo);


            if(producto != null) {

                em.remove(producto);

                System.out.println("Producto eliminado de la BD.");

            }


            em.getTransaction().commit();


        } finally {

            em.close();

        }
    }
}
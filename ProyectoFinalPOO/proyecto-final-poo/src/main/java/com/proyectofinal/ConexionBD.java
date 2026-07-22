package com.proyectofinal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionBD {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("tiendaPU");
            em = emf.createEntityManager();

            System.out.println("Conexion exitosa con MySQL");

        } catch (Exception e) {

            System.out.println("Error de conexion");
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }
}
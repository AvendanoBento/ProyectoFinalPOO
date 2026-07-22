package com.proyectofinal.modelo;

public class ProductoElectronico extends Producto {

    private int garantiaMeses;

    public ProductoElectronico() {
        super();
    }

    public ProductoElectronico(String codigo, String nombre,
                               double precio, int cantidad,
                               int garantiaMeses) {

        super(codigo, nombre, precio, cantidad);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Garantía: " + garantiaMeses + " meses");
    }
}
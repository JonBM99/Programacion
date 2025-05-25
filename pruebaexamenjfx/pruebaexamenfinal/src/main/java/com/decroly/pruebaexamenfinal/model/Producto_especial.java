package com.decroly.pruebaexamenfinal.model;

public class Producto_especial extends Producto {

    private int descuento;

    public Producto_especial(int id, String nombre, String descripcion, double precio, Tipo tipo, int descuento) {
        super(id, nombre, descripcion, precio, tipo);
        this.descuento = descuento;
    }

    public Producto_especial(){}

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto_especial{" +
                "id=" + id +
                ", descuento=" + descuento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }
}

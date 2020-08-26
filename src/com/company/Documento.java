package com.company;

public class Documento {
    private String nombre;
    private String tipo;
    private int hojasCantidad;
    private int peso;

    public Documento(String nombre, String tipo, int hojasCantidad, int peso){
        this.nombre = nombre;
        this.tipo = tipo;
        this.hojasCantidad = hojasCantidad;
        this.peso = peso;
    }

    public String getNombre(){
        return this.nombre;
    }


}

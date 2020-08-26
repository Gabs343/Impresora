package com.company;

public class Impresora {
    private String marca;
    private String color;
    private int hojasCantidad;
    private int memoria;
    private Documento[] documentos = new Documento[5];

    public Impresora(String marca, String color, int memoria, int hojasCantidad){
        this.marca = marca;
        this.color = color;
        this.memoria = memoria;
        this.hojasCantidad = hojasCantidad;
    }

    public void imprimir(int numero){
        System.out.println("Imprimiendo: " + documentos[numero].getNombre() + " de la memoria de la impresora");
    }

    public void imprimirDispositivo(Dispositivo dispositivo, int numero){
        System.out.println("Imprimiendo " + dispositivo.getDocumento(numero).getNombre() + " de la memoria del dispositivo " + dispositivo.getTipo());
    }

    public void setDocumento(int numero, Documento documento){
        documentos[numero] = documento;
    }

    public void escanear(Documento documento){//FALTA AÑADIR AL ARRAY
        System.out.println("Escaneando el documento " + documento.getNombre());

    }

    public void verDispositivo(Dispositivo dispositivo){
        System.out.println("Archivos disponibles en el dispositivo " + dispositivo.getTipo());
        for (int i = 0; i < dispositivo.getDocumentos(); i++){
            System.out.println(dispositivo.getDocumento(i).getNombre());
        }
    }

}

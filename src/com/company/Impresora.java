package com.company;

import java.util.ArrayList;

public class Impresora {
    private String marca;
    private String color;
    private int hojasCantidad;
    private int memoria;
    ArrayList<Documento> docI = new ArrayList<Documento>();

    public Impresora(String marca, String color, int memoria, int hojasCantidad){
        this.marca = marca;
        this.color = color;
        this.memoria = memoria;
        this.hojasCantidad = hojasCantidad;
    }

    public void imprimir(int numero){
        hojasCantidad -= docI.get(numero).getHojasCantidad();
        if (hojasCantidad <= 0){
            System.out.println("ERROR NO QUEDAN HOJAS");
        }else{
            System.out.println("Imprimiendo: " + docI.get(numero).getNombre() + " de la memoria de la impresora");
        }
    }

    public void imprimirDispositivo(Dispositivo dispositivo, int numero){
        hojasCantidad -= dispositivo.getDocumento(numero).getHojasCantidad();
        if (hojasCantidad <= 0){
            System.out.println("ERROR NO QUEDAN HOJAS");
        }else{
            System.out.println("Imprimiendo " + dispositivo.getDocumento(numero).getNombre() + " de la memoria del dispositivo " + dispositivo.getTipo());
        }

    }

    public void setDocumento(Documento documento){
        docI.add(documento);
    }

    public void escanear(Documento documento){
        System.out.println("Escaneando el documento " + documento.getNombre());
        docI.add(documento);
    }

    public void verMemoria(){
        System.out.println("Archivos disponibles en la memoria");
        for (int i = 0; i < docI.size(); i++){
            if(docI.get(i) == null){
                System.out.println("VACIO");
            }else{
                System.out.println(docI.get(i).getNombre());
            }
        }
    }

    public void verDispositivo(Dispositivo dispositivo){
        System.out.println("Archivos disponibles en el dispositivo " + dispositivo.getTipo());
        for (int i = 0; i < dispositivo.getDocumentos(); i++){
            if(dispositivo.docD.get(i) == null){
                System.out.println("VACIO");
            }else{
                System.out.println(dispositivo.getDocumento(i).getNombre());
            }
        }
    }

    public void recargarHojas(int numero){
        hojasCantidad += numero;
    }

}

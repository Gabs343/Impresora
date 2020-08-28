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

    public void removeDoc(int numero, Documento documento){
        docI.remove(numero);
        memoria += documento.getPeso();
    }

    public void removeDocDisp(Dispositivo dispositivo, int numero){
        dispositivo.docD.remove(numero);
        System.out.println(dispositivo.sumaMemoria(numero));
    }

    public void escanear(Documento documento){
        System.out.println("Escaneando el documento " + documento.getNombre());
        docI.add(documento);
        memoria -= documento.getPeso();
    }

    public void verMemoria(){
        System.out.println("Archivos disponibles en la memoria");
        for (int i = 0; i < docI.size(); i++){
            System.out.println(i + ". " + docI.get(i).getNombre());
            memoria -= docI.get(i).getPeso();
        }

        System.out.println("MEMORIA DISPONIBLE " + memoria);
    }

    public void verDispositivo(Dispositivo dispositivo){
        System.out.println("Archivos disponibles en el dispositivo " + dispositivo.getTipo());
        int memoriaD = 0;
        for (int i = 0; i < dispositivo.getDocumentos(); i++){
            System.out.println(i + ". " + dispositivo.getDocumento(i).getNombre());
            memoriaD += dispositivo.getDocumento(i).getPeso();
        }
        System.out.println("MEMORIA DISPONIBLE DEL DISPOSITIVO " + (dispositivo.getMemoria() - memoriaD));;
    }

    public void recargarHojas(int numero){
        hojasCantidad += numero;
        System.out.println("INSERTASTE " + numero + " HOJAS");
    }

    public void moverArchivo(int numero, Dispositivo dispositivo){
        if(dispositivo.getEstado()){
            if(dispositivo.getMemoria() < docI.get(numero).getPeso()){
                System.out.println("NO HAY SUFICIENTE ESPACIO EN EL DISPOSITIVO");
            }else{
                dispositivo.docD.add(docI.get(numero));
                System.out.println(dispositivo.restaMemoria(docI.get(numero).getPeso()));
            }
        }else{
            System.out.println("NO HAY UN DISPOSITIVO CONECTADO");
        }

    }

    public void traerArchivo(int numero, Dispositivo dispositivo){
        if(dispositivo.getEstado()){
            if(memoria < dispositivo.getDocumento(numero).getPeso()){
                System.out.println("NO HAY SUFICIENTE ESPACIO");
            }else{
                docI.add(dispositivo.docD.get(numero));
                memoria -= dispositivo.getDocumento(numero).getPeso();
            }
        }else{
            System.out.println("NO HAY UN DISPOSITIVO CONECTADO");
        }
    }

}

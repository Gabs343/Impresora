package com.company;

import java.util.ArrayList;

public class Dispositivo {
    private String tipo;
    private int memoria;
    private boolean estado;
    //private Documento[] documentos = new Documento[3];
    ArrayList<Documento> docD = new ArrayList<Documento>();

    public Dispositivo(String tipo, int memoria, boolean estado){
        this.tipo = tipo;
        this.memoria = memoria;
        this.estado = estado;
    }

    public void setDocumento(Documento documento){
        docD.add(documento);
    }

    public Documento getDocumento(int numero){
        return docD.get(numero);
    }

    public int getDocumentos(){
        return docD.size();
    }

    public boolean getEstado(){
        return estado;
    }

    public void conectar(){
        estado = true;
    }

    public void desconectar(){
        estado = false;
    }

    public String getTipo(){
        return this.tipo;
    }

}

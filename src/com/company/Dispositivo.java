package com.company;

public class Dispositivo {
    private String tipo;
    private int memoria;
    private boolean estado;
    private Documento[] documentos = new Documento[3];

    public Dispositivo(String tipo, int memoria, boolean estado){
        this.tipo = tipo;
        this.memoria = memoria;
        this.estado = estado;
    }

    public void setDocumento(int numero, Documento documento){
        documentos[numero] = documento;
    }

    public Documento getDocumento(int numero){
        return documentos[numero];
    }

    public int getDocumentos(){
        return documentos.length;
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

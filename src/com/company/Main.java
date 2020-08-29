package com.company;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Random rnd = new Random();
        //DOCUMENTOS
        Documento contrato = new Documento("CONTRATO", "WORD", 7, rnd.nextInt(5000));
        Documento calculo = new Documento("CALCULO", "XLSX", 1, 343);
        Documento trabajo = new Documento("TRABAJO", "WORD", 10, 500);
        Documento libro = new Documento("LIBRO", "PDF", 200, 3000);
        Documento presentacion = new Documento("PRESENTACION", "PPTX", 15, 1000);
        Documento paquete = new Documento("PAQUETE", "RAR", 0, 7000000);

        //IMPRESORA CON UN DOCUMENTO EN SU MEMORIA
        Impresora hp = new Impresora("HP", "WHITE", 1000000, 50);
        hp.setDocumento(trabajo);
        hp.setDocumento(libro);

        //DISPOSITIVO PENDRIVE CON 3 DOCUMENTOS EN SU MEMORIA
        Dispositivo pendrive = new Dispositivo("PENDRIVE", 8000000, false);
        pendrive.setDocumento(calculo);
        pendrive.setDocumento(libro);
        pendrive.setDocumento(presentacion);
        pendrive.setDocumento(paquete);

        //DISPOSITIVO SD
        Dispositivo sd = new Dispositivo("SD", 2000000, false);


        //ACCIONES
        hp.verMemoria();
        pendrive.conectar();
        hp.traerArchivo(1, pendrive);
        hp.verMemoria();
        hp.escanear(contrato);
        hp.verMemoria();
        hp.moverArchivo(3, pendrive);
        hp.verDispositivo(pendrive);
        hp.removeDoc(2, libro);
        hp.verMemoria();
        hp.imprimir(1);
        hp.recargarHojas(400);
        hp.imprimir(1);
        hp.removeDocDisp(pendrive, 3);
        hp.verDispositivo(pendrive);
        /*hp.imprimir(0);
        hp.recargarHojas(200);
        pendrive.conectar();
        if (pendrive.getEstado()) {
            hp.imprimirDispositivo(pendrive, 0);
            hp.imprimirDispositivo(pendrive, 1);
            hp.imprimirDispositivo(pendrive, 2);
        } else {
            System.out.println("ERROR NO HAY NINGUN DISPOSITIVO CONECTADO");
        }

        hp.escanear(contrato);
        hp.verDispositivo(pendrive);
        hp.verMemoria();

        hp.moverArchivo(0, pendrive);
        hp.verDispositivo(pendrive);
        hp.traerArchivo(3, pendrive);*/
    }
}

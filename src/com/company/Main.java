package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //IMPRESORA CON UN DOCUMENTO EN SU MEMORIA
        Impresora hp = new Impresora("HP", "WHITE", 1000000, 50);
        hp.setDocumento(new Documento("TRABAJO", "WORD", 10, 500));

        //DISPOSITIVO PENDRIVE CON 3 DOCUMENTOS EN SU MEMORIA
        Dispositivo pendrive = new Dispositivo("PENDRIVE", 8000000, false);
        pendrive.setDocumento(new Documento("CALCULO", "XLSX", 1, 343));
        pendrive.setDocumento(new Documento("LIBRO", "PDF", 200, 3000));
        pendrive.setDocumento(new Documento("PRESENTACION", "PPTX", 15, 1000));

        //DISPOSITIVO SD
        Dispositivo sd = new Dispositivo("SD", 2000000, false);

        //DOCUMENTO
        Documento archivo1 = new Documento("CONTRATO", "WORD", 7, 0);

        //ACCIONES
        hp.imprimir(0);
        hp.recargarHojas(200);
        pendrive.conectar();
        if(pendrive.getEstado()){
            hp.imprimirDispositivo(pendrive, 0);
            hp.imprimirDispositivo(pendrive, 1);
            hp.imprimirDispositivo(pendrive, 2);
        }else{
            System.out.println("ERROR NO HAY NINGUN DISPOSITIVO CONECTADO");
        }

        hp.escanear(archivo1);
        hp.verDispositivo(pendrive);
        hp.verMemoria();

        hp.moverArchivo(0, pendrive);
        hp.verDispositivo(pendrive);



    }
}

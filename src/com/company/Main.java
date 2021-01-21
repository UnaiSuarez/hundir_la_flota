package com.company;

import com.company.clases.Barco;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Orientacion;
import com.company.gestores.GestorColocacion;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tamTablero = 10;

        Barco[][] tablero = new Barco[tamTablero][tamTablero];

        GestorColocacion gestorColocacion = new GestorColocacion();
        gestorColocacion.colocarBarco(tablero);
        gestorColocacion.mostrarTablero(tablero);


    }


}

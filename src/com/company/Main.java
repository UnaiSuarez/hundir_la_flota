package com.company;

import com.company.clases.Barco;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Jugador;
import com.company.clases.Orientacion;
import com.company.gestores.GestorAtaque;
import com.company.gestores.GestorColocacion;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador(false,"bot 1");
        Jugador jugador2 = new Jugador(false,"bot 2");

        GestorColocacion gestorColocacionJugador = new GestorColocacion();
        GestorAtaque gestorAtaque = new GestorAtaque();
        gestorColocacionJugador.menuPrincipal(jugador1);
        gestorColocacionJugador.menuPrincipal(jugador2);
        gestorAtaque.ataques(jugador1,jugador2);


    }


}

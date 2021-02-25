package com.company.gestores;

import com.company.clases.Jugador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class GestorMenu {
    private ArrayList<Jugador> partidas;
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        limpiarPantalla();
        System.out.println("OPCIONES");
        System.out.println("--------");
        System.out.println("1) Modo de juego\n2) Ver partidas");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            menuModo();
        }
        else if (opcion.equals("2")){

        }
        else {
            System.out.println(opcion + ", No es una opcion");
            menu();
        }
    }

    private void menuModo(){
        limpiarPantalla();
        System.out.println("Has elegido modo de juego:");
        System.out.println("--------------------------");
        System.out.println("1) Jugador VS Bot\n2) Bot VS Bot\n3) Atras");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            limpiarPantalla();
            System.out.println("Jugador VS Bot");
            System.out.println("Elige un nombre para el jugador");
            System.out.print("Nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Nombre elegido; "+nombre);
            Jugador jugador = new Jugador(true,nombre);
            Jugador bot = new Jugador(false,"bot");
            GestorColocacion gestorColocacionJugador = new GestorColocacion();
            GestorAtaque gestorAtaque = new GestorAtaque();
            gestorColocacionJugador.menuPrincipal(jugador);
            gestorColocacionJugador.menuPrincipal(bot);
            gestorAtaque.ataques(jugador,bot);
        }
        else if (opcion.equals("2")){
            limpiarPantalla();
            System.out.println("Bot VS Bot");
            Jugador bot1 = new Jugador(false,"bot1");
            Jugador bot2 = new Jugador(false,"bot2");
            GestorColocacion gestorColocacionJugador = new GestorColocacion();
            GestorAtaque gestorAtaque = new GestorAtaque();
            gestorColocacionJugador.menuPrincipal(bot1);
            gestorColocacionJugador.menuPrincipal(bot2);
            gestorAtaque.ataques(bot1,bot2);
        }
        else if (opcion.equals("3")){
            menu();
        }
        else {
            System.out.println(opcion + ", No es una opcion");
            menuModo();
        }
    }

    public void limpiarPantalla(){
        for (int i = 0; i < 200; i++) {
            System.out.println("");
        }
    }


}

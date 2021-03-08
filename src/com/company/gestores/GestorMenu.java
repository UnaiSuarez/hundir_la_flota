package com.company.gestores;

import com.company.clases.DAO.DAOFactory;
import com.company.clases.Dificultad;
import com.company.clases.Jugador;
import com.company.clases.Partida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class GestorMenu {
    private List<Partida> partidas;
    Scanner scanner = new Scanner(System.in);
    GestorColocacion gestorColocacion = new GestorColocacion();
    public void menu(){
        System.out.println("OPCIONES");
        System.out.println("--------");
        System.out.println("1) Modo de juego\n2) Ver partidas\n3) Salir");
        System.out.print("Opcion:");
        String opcion = scanner.nextLine();
        if (opcion.equals("1")){
            menuModo();
        }
        else if (opcion.equals("2")){
            limpiarPantalla();
            partidas =  DAOFactory.getInstance().getDaoPartidas().damePartidas();
            if(partidas.size()>0) {
                System.out.println("Elije una partida");
                for (int i = 0; i < partidas.size(); i++) {
                    System.out.println("partida: " + i+", "+partidas.get(i).getFecha());
                }
                System.out.print("Partida-->");
                int opcionPartida = Integer.parseInt(scanner.nextLine());
                if (partidas.get(opcionPartida).getJ1().getVida() == 0) {
                    muestraPartida(partidas.get(opcionPartida).getJ1(), partidas.get(opcionPartida).getJ2());
                } else {
                    muestraPartida(partidas.get(opcionPartida).getJ2(), partidas.get(opcionPartida).getJ1());
                }
            }
            menu();
        }
        else if (opcion.equals("3")){
            System.out.println("Gracias por jugar ;)");
            return;
        }
        else {
            System.out.println(opcion + "No es una opcion");
            menu();
        }
    }

    private void menuModo(){
        limpiarPantalla();
        System.out.println("Has elegido modo de juego:");
        System.out.println("--------------------------");
        Dificultad dificultad = null;
        System.out.println("La ultima dificultad fué: "+DAOFactory.getInstance().getDaoDificultad().dameDificultad()+"\n¿Desea cambiarla?");
        String dificultadOpcion = scanner.nextLine();
        if (dificultadOpcion.equals("si")){
            System.out.println("Elije dificultad:\n1) Facil\n2) Dificil\nOpción:");
            String dif = scanner.nextLine();
            if (dif.equals("1")){
                dificultad = Dificultad.FACIL;
            }
            else {
                dificultad = Dificultad.DIFICIL;
            }
        }
        else {
            dificultad = DAOFactory.getInstance().getDaoDificultad().dameDificultad();
        }

        limpiarPantalla();
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
            GestorAtaque gestorAtaque = new GestorAtaque(dificultad);
            gestorColocacionJugador.menuPrincipal(jugador);
            gestorColocacionJugador.menuPrincipal(bot);
            gestorAtaque.ataques(jugador,bot);
        }
        else if (opcion.equals("2")){
            limpiarPantalla();
            System.out.println("Bot VS Bot");
            Jugador bot1 = new Jugador(false,"bot1");
            Jugador bot2 = new Jugador(false,"bot2");
            GestorAtaque gestorAtaque = new GestorAtaque(dificultad);
            gestorColocacion.menuPrincipal(bot1);
            gestorColocacion.menuPrincipal(bot2);
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
private void muestraPartida(Jugador jugador1, Jugador jugador2){
    System.out.println("el jugador "+jugador1.getNombre()+" ha perdido");
    System.out.println("--------------------------------------------------");
    System.out.println("los tableros finales han quedado asi");
    gestorColocacion.mostrarTableros(jugador1);
    System.out.println("--------------------------------------------------");
    gestorColocacion.mostrarTableros(jugador2);
    System.out.println("--------------------------------------------------");
    menu();
}

}

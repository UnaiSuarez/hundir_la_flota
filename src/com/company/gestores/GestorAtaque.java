package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Barcos.Acorazado;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Jugador;
import com.company.clases.Orientacion;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GestorAtaque {
private String dificultad;

    public GestorAtaque(String dificultad) {
        this.dificultad = dificultad;
    }

    GestorColocacion gestorColocacionJugador = new GestorColocacion();
    GestorMenu gestorMenu = new GestorMenu();
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_WHITE = "\033[0m";
    String ANSI_RED = "\u001B[33m";
    int tirada = 0;
    public void ataques(Jugador jugador1, Jugador jugador2){
      //  jugador1.setGestionable(true);
            while (jugador1.getVida() >= 0 || jugador2.getVida() >=0){
                if (jugador1.getVida() == 0){
                    System.out.println("el jugador "+jugador1.getNombre()+" ha perdido");
                    System.out.println("--------------------------------------------------");
                    System.out.println("los tableros finales han quedado asi");
                    mostrarTableros(jugador1);
                    System.out.println("--------------------------------------------------");
                    mostrarTableros(jugador2);
                    System.out.println("--------------------------------------------------");
                    break;
                }
                else if (jugador2.getVida() == 0){
                    System.out.println("el jugador "+jugador2.getNombre()+" ha perdido");
                    System.out.println("--------------------------------------------------");
                    System.out.println("los tableros finales han quedado asi");
                    mostrarTableros(jugador2);
                    System.out.println("--------------------------------------------------");
                    mostrarTableros(jugador1);
                    System.out.println("--------------------------------------------------");
                    break;
                }
                else {
                    if (tirada%2 == 0){
                        if(ataque(jugador1,jugador2)){
                            tirada++;
                        }
                    }
                    else {
                        if(ataque(jugador2,jugador1)){
                            tirada++;
                        }
                    }
                }
            }
    }

private Boolean ataque(Jugador jugadorAtaque,Jugador jugadorAtacado){
    try {
        TimeUnit.MILLISECONDS.sleep(30);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    int x = 0;
    int y =0;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    if (jugadorAtaque.isGestionable()){
        System.out.println("Elije una posicion donde atacar");
        System.out.print("X:");
         x = scanner.nextInt();
        System.out.print("Y:");
        y = scanner.nextInt();
    }
    else {
        x = random.nextInt(jugadorAtaque.getTamTablero());
        y = random.nextInt(jugadorAtaque.getTamTablero());
        if (dificultad.equals("2")){
            if (jugadorAtaque.isTocado()){
                boolean posicion = random.nextBoolean();
                boolean posicionXoY = random.nextBoolean();
                if (posicionXoY){
                    if (posicion){
                        x = jugadorAtaque.getTiradax() +1;
                        y = jugadorAtaque.getTiraday();
                    }
                    else {
                        x = jugadorAtaque.getTiradax() -1;
                        y = jugadorAtaque.getTiraday();;
                    }

                }
                else {
                    if (posicion){
                        y = jugadorAtaque.getTiraday() +1;
                        x = jugadorAtaque.getTiradax();
                    }
                    else {
                        y = jugadorAtaque.getTiraday() -1;
                        x = jugadorAtaque.getTiradax();
                    }

                }
            }
        }
    }
    if (x < jugadorAtaque.getTamTablero() && x >= 0 && y < jugadorAtaque.getTamTablero() && y >= 0){
        if (jugadorAtaque.getTableroAtaque()[x][y] == 0 ){
            if (jugadorAtacado.getTablero()[x][y] != null){
                jugadorAtaque.getTableroAtaque()[x][y] = 2;
                if (jugadorAtacado.getTablero()[x][y].getVida() > 0){
                    jugadorAtacado.getTablero()[x][y].restaVida();
                    System.out.println("\n");
                    if (jugadorAtacado.getTablero()[x][y].getVida() == 0) {
                        System.out.println(jugadorAtaque.getNombre()+" ha atacado la posicion x:"+x+", y:"+y+" en la tirada:"+tirada);
                        System.out.println("hundido");
                        cambioTablero(jugadorAtacado,x,y);
                        if (muestraTablero(jugadorAtaque, jugadorAtacado)){
                            mostrarTableros(jugadorAtaque);
                        }
                        jugadorAtaque.setTocado(false);

                    }
                    else {
                        System.out.println(jugadorAtaque.getNombre()+" ha atacado la posicion x:"+x+", y:"+y+" en la tirada:"+tirada);
                        System.out.println("tocado");
                        cambioTablero(jugadorAtacado,x,y);
                        if (muestraTablero(jugadorAtaque,jugadorAtacado)){
                            mostrarTableros(jugadorAtaque);
                        }
                        jugadorAtaque.setTocado(true);
                        jugadorAtaque.setTiradax(x);
                        jugadorAtaque.setTiraday(y);

                    }

                    jugadorAtacado.restaVida();
                }

            }
            else {
                System.out.println("\n");
                jugadorAtaque.getTableroAtaque()[x][y] = 1;
                System.out.println(jugadorAtaque.getNombre() + " ha atacado la posicion x:" + x + ", y:" + y+" en la tirada:"+tirada);
                System.out.println("agua");
                if (muestraTablero(jugadorAtaque,jugadorAtacado)){
                    mostrarTableros(jugadorAtaque);
                }
                jugadorAtaque.setTocado(false);
            }
        }
        else {
            if (jugadorAtaque.isGestionable()){
                System.out.println(jugadorAtaque.getNombre()+" ha repetido el tiro, "+tirada);
            }
            jugadorAtaque.setTocado(false);
            return false;
        }
    }
    else {
        if (jugadorAtaque.isGestionable()){
            System.out.println("No es posible esa posicion");
        }
    }

    return true;
}

private boolean muestraTablero(Jugador jugadorAtaque, Jugador jugadorAtacado){
        if (!jugadorAtaque.isGestionable() && !jugadorAtacado.isGestionable()){
            return true;
        }
        else if (tirada%2==0 && jugadorAtaque.isGestionable() && !jugadorAtacado.isGestionable()){
            return true;
        }
        return false;
}

private void mostrarTableros(Jugador jugadorAtaque){
    System.out.println("Tablero:"+jugadorAtaque.getNombre());
    System.out.println("tablero ataque: ");
    System.out.print(" ");
    for (int i = 0; i < jugadorAtaque.getTamTablero(); i++) {
        System.out.print(" "+i);
    }
    System.out.println();
    for(int x = 0; x < jugadorAtaque.getTamTablero(); x++){
        System.out.print(x+" ");
        for(int y = 0; y < jugadorAtaque.getTamTablero(); y++){
            if(jugadorAtaque.getTableroAtaque()[x][y] == 1){
                System.out.print(ANSI_WHITE+"█"+ANSI_RESET);
            }
            else if (jugadorAtaque.getTableroAtaque()[x][y] == 2){
                System.out.print(ANSI_RED+"█"+ANSI_RESET);
            }
            else{
                System.out.print(ANSI_BLUE+"█"+ANSI_RESET);
            }
            System.out.print(" ");
        }
        System.out.println("");
    }
    System.out.println("Tablero barcos:");
    gestorColocacionJugador.mostrarTablero(jugadorAtaque);
}

private void cambioTablero(Jugador jugador, int x, int y){
    Orientacion orientacion = jugador.getTablero()[x][y].getOrientacion();
    if (orientacion == Orientacion.VERTICAL){
        Integer yMostrar = y -jugador.getTablero()[x][y].getY();
        jugador.getTablero()[x][y].aplicaDaño(yMostrar);
    }
    else {
        Integer xMostrar = x - jugador.getTablero()[x][y].getX();
        jugador.getTablero()[x][y].aplicaDaño(xMostrar);
    }


}
}

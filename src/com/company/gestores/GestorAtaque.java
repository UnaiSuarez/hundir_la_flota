package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Barcos.Acorazado;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Jugador;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GestorAtaque {

    GestorColocacion gestorColocacionJugador = new GestorColocacion();
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_WHITE = "\033[0m";
    String ANSI_RED = "\u001B[33m";
    public void ataques(Jugador jugador1, Jugador jugador2){
            int tirada = 0;
            while (jugador1.getVida() >= 0 || jugador2.getVida() >=0){
                if (jugador1.getVida() == 0){
                    System.out.println("el jugador "+jugador1.getNombre()+" ha perdido");
                    System.out.println("--------------------------------------------------");
                    System.out.println("los tableros finales han quedado asi");
                    mostrarTableros(jugador1,jugador2);
                    System.out.println("--------------------------------------------------");
                    mostrarTableros(jugador2,jugador1);
                    System.out.println("--------------------------------------------------");
                    break;
                }
                else if (jugador2.getVida() == 0){
                    System.out.println("el jugador "+jugador2.getNombre()+" ha perdido");
                    System.out.println("--------------------------------------------------");
                    System.out.println("los tableros finales han quedado asi");
                    mostrarTableros(jugador2,jugador1);
                    System.out.println("--------------------------------------------------");
                    mostrarTableros(jugador1,jugador2);
                    System.out.println("--------------------------------------------------");
                    break;
                }

                else {
                    if (tirada%2 == 0){
                        ataque(jugador1,jugador2,tirada);
                    }
                    else {
                        ataque(jugador2,jugador1,tirada);
                    }
                }
                tirada++;

            }
    }

private void ataque(Jugador jugadorAtaque,Jugador jugadorAtacado, int tirada){
    try {
        TimeUnit.MILLISECONDS.sleep(1);
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
         x = random.nextInt(10);
         y = random.nextInt(10);
    }
    if (jugadorAtaque.getTableroAtaque()[x][y] == 0 ){
        if (jugadorAtacado.getTablero()[x][y] != null){
            jugadorAtaque.getTableroAtaque()[x][y] = 2;
            if (jugadorAtacado.getTablero()[x][y].getVida() > 0){
                jugadorAtacado.getTablero()[x][y].restaVida();
                System.out.println(jugadorAtaque.getNombre()+" ha atacado la posicion x:"+x+", y:"+y+" en la tirada:"+tirada);
                if (jugadorAtacado.getTablero()[x][y].getVida() == 0) {
                    mostrarTableros(jugadorAtaque,jugadorAtacado);
                    System.out.println("hundido");
                }
                else {
                    mostrarTableros(jugadorAtaque,jugadorAtacado);
                    System.out.println("tocado");
                }

                jugadorAtacado.restaVida();
            }

        }
        else {
            jugadorAtaque.getTableroAtaque()[x][y] = 1;
            mostrarTableros(jugadorAtaque,jugadorAtacado);
            System.out.println(jugadorAtaque.getNombre() + " ha atacado la posicion x:" + x + ", y:" + y+" en la tirada:"+tirada);
            System.out.println("agua");
        }
    }
    else {
       mostrarTableros(jugadorAtaque,jugadorAtacado);
        System.out.println(jugadorAtaque.getNombre()+" ha repetido el tiro, "+tirada);
        tirada--;
        ataque(jugadorAtaque,jugadorAtacado,tirada);
    }

}

private void mostrarTableros(Jugador jugadorAtaque, Jugador jugadorAtacado){
    System.out.println("tablero basrcos:");
        gestorColocacionJugador.mostrarTablero(jugadorAtaque);
    System.out.println("tablero ataque: ");
    System.out.print(" ");
    for (int i = 0; i < jugadorAtaque.getTamTablero(); i++) {
        System.out.print(" "+i);
    }
    System.out.println();
    for(int x = 0; x < jugadorAtaque.getTamTablero(); x++){
        System.out.print(x+" ");
        for(int y = 0; y < jugadorAtacado.getTamTablero(); y++){
            if(jugadorAtacado.getTableroAtaque()[y][x] == 1){
                System.out.print(ANSI_WHITE+"█"+ANSI_RESET);
            }
            else if (jugadorAtacado.getTableroAtaque()[y][x] == 2){
                System.out.print(ANSI_RED+"█"+ANSI_RESET);
            }
            else{
                System.out.print(ANSI_BLUE+"█"+ANSI_RESET);
            }
            System.out.print(" ");
        }
        System.out.println("");
    }
    System.out.println("\n\n\n");


}
}

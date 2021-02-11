package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Jugador;

import java.io.Serializable;
import java.util.Random;

public class GestorAtaque {

    public void ataque(Jugador jugador1, Jugador jugador2){
        for (int i = 0; i < jugador1.getTamTablero(); i++) {
            for (int j = 0; j < jugador1.getTamTablero(); j++) {
                jugador1.getTableroAtaque()[i][j] = 0;
            }
        }
        for (int i = 0; i <= 200; i++) {
            Random random = new Random();
            while (jugador1.getVida() >= 0 || jugador2.getVida() >=0){
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (i%2 == 0){
                    if (jugador1.getTableroAtaque()[x][y] == 0 ){
                        jugador1.getTableroAtaque()[x][y] = 1;
                        System.out.println("agua");
                    }
                    else {
                        if (jugador1.getTablero()[x][y].getVida() > 0){
                            System.out.println("tocado");
                            jugador1.getTablero()[x][y].restaVida();
                            jugador1.restaVida();
                            jugador2.restaVida();
                        }
                        else {
                            System.out.println("hundido");
                            jugador1.restaVida();
                            jugador2.restaVida();
                        }
                    }
                }

            }
        }

    }
}

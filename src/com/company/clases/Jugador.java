package com.company.clases;

import com.company.clases.Barcos.Acorazado;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;

public class Jugador {
    private String nombre;
    private boolean gestionable;
    int tamTablero = 10;
    Barco[][] tablero;
    int[][] tableroAtaque;
    private int numTotalBarcos = 10;
    private int numAcorazados = 2;
    private int numMinas = 4;
    private int numDestructor = 3;
    private int numPortaaviones = 1;
    private int vida = 24;


    public Jugador(boolean gestionable, String nombre) {
        this.gestionable = gestionable;
        this.tablero = new Barco[tamTablero][tamTablero];
        this.tableroAtaque = new int[tamTablero][tamTablero];
        this.nombre = nombre;
    }

    public void resta(Class type){
            if(type==Portaaviones.class) {
                numPortaaviones--;
            }
            else if(type==Destructor.class) {
                numDestructor--;
            }
            else if(type==Acorazado.class) {
                numAcorazados--;
            }
            else if(type==Mina.class) {
                numMinas--;
            }

            numTotalBarcos--;
    }

    public void restaVida(){
        this.vida--;
    }

    public boolean isGestionable() {
        return gestionable;
    }

    public Barco[][] getTablero() {
        return tablero;
    }

    public int getTamTablero() {
        return tamTablero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumTotalBarcos() {
        return numTotalBarcos;
    }

    public int getNumAcorazados() {
        return numAcorazados;
    }

    public int getNumMinas() {
        return numMinas;
    }

    public int getNumDestructor() {
        return numDestructor;
    }

    public int getNumPortaaviones() {
        return numPortaaviones;
    }

    public int getVida(){return vida;}

    public int[][] getTableroAtaque(){ return tableroAtaque;}

    public Boolean modoJuego(){
        this.gestionable = true;
        return true;
    }

    public void setGestionable(boolean gestionable) {
        this.gestionable = gestionable;
    }
}

package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

import javax.sound.sampled.Line;

public class Portaaviones extends Barco {
    private  final static  Integer numCeldasPortaaviones = 6;
    private final static  String color = "\u001B[33m";

    public Portaaviones(Integer x, Integer y, Orientacion orientacion) {
        super(numCeldasPortaaviones,x,y, orientacion, color);
        setVida(6);
    }

    public static String getColor() {
        return color;
    }
}

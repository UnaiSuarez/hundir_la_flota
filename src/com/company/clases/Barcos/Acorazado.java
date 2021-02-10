package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Acorazado extends Barco {
    private  final static  Integer numAcorazado = 4;
    private  final static  Integer vida = 4;
    private final  static String color = "\u001B[30m";

    public Acorazado(Integer x, Integer y, Orientacion orientacion) {
        super(numAcorazado,vida,x,y,orientacion, color);
    }

    public static String getColor() {
        return color;
    }
}

package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Mina extends Barco {
    private  final static  Integer numMinas = 1;
    private  final static  Integer vida = 1;
    private  final static String color = "\u001B[32m";

    public Mina(Integer x, Integer y, Orientacion orientacion) {
        super(numMinas,vida,x,y,orientacion,color);
    }

    public static String getColor() {
        return color;
    }
}

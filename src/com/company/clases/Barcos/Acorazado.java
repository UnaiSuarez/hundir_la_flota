package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

import java.io.Serializable;

public class Acorazado extends Barco implements Serializable {
    private  final static  Integer numAcorazado = 4;
    private final  static String color = "\u001B[30m";

    public Acorazado(Integer x, Integer y, Orientacion orientacion) {
        super(numAcorazado,x,y,orientacion, color);
        setVida(4);
    }

}

package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

import java.awt.*;
import java.io.Serializable;

public class Mina extends Barco implements Serializable {
    private  final static  Integer numMinas = 1;
    private  final static String color = "\u001B[32m";

    public Mina(Integer x, Integer y, Orientacion orientacion) {
        super(numMinas,x,y,orientacion,color);
        setVida(1);
    }


}

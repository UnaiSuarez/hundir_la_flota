package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Destructor extends Barco {
    private  final static  Integer numDestructor = 2;
    private  final static String color = "\u001B[31m";

    public Destructor(Integer x, Integer y, Orientacion orientacion) {
        super(numDestructor,x,y,orientacion,color);
        setVida(2);
    }


}

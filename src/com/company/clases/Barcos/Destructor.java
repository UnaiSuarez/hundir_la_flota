package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Destructor extends Barco {
    private  final static  Integer numCeldasPortaaviones = 2;

    public Destructor(Integer x, Integer y, Orientacion orientacion) {
        super(numCeldasPortaaviones,x,y,orientacion);
    }
}

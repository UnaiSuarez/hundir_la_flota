package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Mina extends Barco {
    private  final static  Integer numCeldasPortaaviones = 1;

    public Mina(Integer x, Integer y, Orientacion orientacion) {
        super(numCeldasPortaaviones,x,y,orientacion);
    }
}

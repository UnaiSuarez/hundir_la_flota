package com.company.clases.Barcos;

import com.company.clases.Barco;
import com.company.clases.Orientacion;

public class Acorazado extends Barco {
    private  final static  Integer numCeldasPortaaviones = 4;

    public Acorazado(Integer x, Integer y, Orientacion orientacion) {
        super(numCeldasPortaaviones,x,y,orientacion);
    }
}

package com.company.clases;

import javax.print.attribute.standard.OrientationRequested;

public abstract class Barco {
    protected Integer numCeldas, x, y;
    protected Orientacion orientacion;

    public Barco(Integer numCeldas, Integer x, Integer y, Orientacion orientacion) {
        this.numCeldas = numCeldas;
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }

    public Integer getNumCeldas() {
        return numCeldas;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }
}

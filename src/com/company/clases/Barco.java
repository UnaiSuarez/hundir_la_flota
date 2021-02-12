package com.company.clases;

import javax.print.attribute.standard.OrientationRequested;

public abstract class Barco {
    protected Integer numCeldas, x, y,vida;
    protected Orientacion orientacion;
    String color;

    public Barco(Integer numCeldas, Integer x, Integer y, Orientacion orientacion, String color) {
        this.numCeldas = numCeldas;
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.orientacion = orientacion;
        this.color = color;
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

    public Integer getVida() {
        return vida;
    }

    protected void setVida(Integer vida) {
        this.vida = vida;
    }

    public void restaVida(){
        this.vida--;
    }


}

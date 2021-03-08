package com.company.clases;

import com.company.clases.Barcos.Estado;

import javax.print.attribute.standard.OrientationRequested;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Barco implements Serializable {
    protected Integer numCeldas, x, y,vida;
    protected Orientacion orientacion;
    String color;
    Estado[] estado;

    public Barco(Integer numCeldas, Integer x, Integer y, Orientacion orientacion, String color) {
        this.numCeldas = numCeldas;
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.orientacion = orientacion;
        this.color = color;
        this.estado = new Estado[numCeldas];
        for (int i = 0; i < numCeldas; i++) {
            this.estado[i] = Estado.OK;
        }
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

    public String getColor() {
        return color;
    }

    protected void setVida(Integer vida) {
        this.vida = vida;
    }

    public void restaVida(){
        this.vida--;
    }

    public Estado getEstado(int index) {
        return estado[index];
    }

    public void aplicaDaño(int index) {
        if(vida>0) {
            this.estado[index] = Estado.TOCADO;
        }
        else {
            this.estado[index] = Estado.HUNDIDO;
        }
    }

}

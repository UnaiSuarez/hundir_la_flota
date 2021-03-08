package com.company.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Partida implements Serializable {

    private Jugador j1, j2;
    private LocalDate fecha;

    public Partida(Jugador j1, Jugador j2, LocalDate fecha) {
        this.j1 = j1;
        this.j2 = j2;
        this.fecha = fecha;
    }

    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

}

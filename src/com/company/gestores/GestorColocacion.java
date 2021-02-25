package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Barcos.*;
import com.company.clases.Jugador;
import com.company.clases.Orientacion;


import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class GestorColocacion {


    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";



    public void menuPrincipal(Jugador jugador){
        if (jugador.isGestionable()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Colocar aleatoriamente");
            System.out.print("Opcion:");
            String opcion = scanner.nextLine();
            if (opcion.equals("si")){
                menuBarcosBot(jugador);
            }
            else menuBarcos(jugador);
        }
        else menuBarcosBot(jugador);

    }

    private void menuBarcos(Jugador jugador){
        if (jugador.getNumTotalBarcos() == 0){
            mostrarTablero(jugador);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elija un barco:");
            System.out.println("1) Portaaviones: "+jugador.getNumPortaaviones());
            System.out.println("2) Destructor: "+jugador.getNumDestructor());
            System.out.println("3) Acorazado: "+jugador.getNumAcorazados());
            System.out.println("4) Minas: "+jugador.getNumMinas());
            System.out.println("5) Salir");
            System.out.print("Opcion:");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1" -> colocarBarco(Portaaviones.class, jugador);
                case "2" -> colocarBarco(Destructor.class, jugador);
                case "3" -> colocarBarco(Acorazado.class, jugador);
                case "4" -> colocarBarco(Mina.class, jugador);
                case "5" -> mostrarTablero(jugador);
                default -> {
                    System.out.println(opcion + " no es una opcion");
                    menuBarcos(jugador);
                }
            }

        }
    }

    private void menuBarcosBot(Jugador jugador){
        while (jugador.getNumTotalBarcos() > 0){
            if (jugador.getNumPortaaviones() > 0){
                colocarBarcosBot(Portaaviones.class, jugador);
            }
            if (jugador.getNumAcorazados() > 0){
                colocarBarcosBot(Acorazado.class, jugador);
            }
            if (jugador.getNumDestructor() > 0){
                colocarBarcosBot(Destructor.class, jugador);
            }
            if (jugador.getNumMinas() > 0){
                colocarBarcosBot(Mina.class, jugador);
            }
        }
    }

    private void colocarBarco(Class type, Jugador jugador){
        Barco barco = generateJugador(type, jugador);
        if (barco.getOrientacion() == Orientacion.HORIZONTAL){
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (jugador.getTablero()[barco.getX()][barco.getY()+e] != null){
                        hueco = false;
                    }
                } catch (Exception exception) {
                    System.out.println("Fuera del tablero");
                    menuBarcos(jugador);
                }
            }
            if (!hueco){
                System.out.println("no es posible colocar el barco");
            }
            else if (hueco){
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()][barco.getY()+o] = barco;
                }
                jugador.resta(type);
            }
        }
        else {
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (jugador.getTablero()[barco.getX()+e][barco.getY()] != null){
                        hueco = false;
                    }
                } catch (Exception exception) {
                    System.out.println("fuera del tablero");
                    menuBarcos(jugador);
                }

            }
            if (!hueco){
                System.out.println("no es posible colocar el barco");
            }
            else if (hueco){
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()+o][barco.getY()] = barco;
                }
                jugador.resta(type);
            }
        }
        menuBarcos(jugador);


    }


private void colocarBarcosBot(Class type, Jugador jugador){
    Barco barco = generateBot(type);

    if (barco.getOrientacion() == Orientacion.HORIZONTAL){
            boolean opcion = true;
            for (int i = 0; i < barco.getNumCeldas() ; i++) {
                if(jugador.getTablero().length < barco.getX()+barco.getNumCeldas() || jugador.getTablero()[barco.getX()+i][barco.getY()] != null){
                    opcion =  false;
                }
            }
            if(!opcion){
                menuBarcosBot(jugador);
            }
            else {
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()+o][barco.getY()] = barco;
                }
                jugador.resta(type);
            }


    }
    else {
            boolean opcion = true;
            for (int i = 0; i < barco.getNumCeldas() ; i++) {
                if(jugador.getTablero().length < barco.getY()+barco.getNumCeldas() || jugador.getTablero()[barco.getX()][barco.getY()+i] != null){
                    opcion =  false;
                }
            }
            if(!opcion){
                menuBarcosBot(jugador);
            }
            else {
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()][barco.getY()+o] = barco;
                }
                jugador.resta(type);
            }
    }
    menuBarcosBot(jugador);


}

    private Barco generateJugador(Class type, Jugador jugador){
        mostrarTablero(jugador);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elije una posición:");
        System.out.print("Posicion x:");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Posicion y:");
        int y = Integer.parseInt(scanner.nextLine());
        System.out.print("Orientación:");
        String posicion = scanner.nextLine();
        Orientacion orientacion = Orientacion.VERTICAL;
        if(posicion.equals("horizontal")){
            orientacion = Orientacion.HORIZONTAL;
        }
        return generateAll(type,x,y,orientacion);
    }

    private Barco generateBot(Class type){
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        Boolean e = new Random().nextBoolean();
        boolean posicion = e.booleanValue();
        Orientacion orientacion = Orientacion.VERTICAL;
        if(posicion){
            orientacion = Orientacion.HORIZONTAL;
        }
        return generateAll(type,x,y,orientacion);
    }

    private Barco generateAll(Class type, int x, int y, Orientacion orientacion){
        if(Portaaviones.class == type){
            return new Portaaviones(x,y,orientacion);
        }
        else if(Acorazado.class == type){
            return new Acorazado(x,y,orientacion);
        }
        else if(Destructor.class == type){
            return new Destructor(x,y,orientacion);
        }
        else if(Mina.class == type){
            return new Mina(x,y,orientacion);
        }
        else return null;
    }

    public void mostrarTablero(Jugador jugador){
        System.out.println("tablero: "+jugador.getNombre());
        System.out.print(" ");
        for (int i = 0; i < jugador.getTamTablero(); i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for(int x = 0; x < jugador.getTamTablero(); x++){
            System.out.print(x+" ");
            for(int y = 0; y < jugador.getTamTablero(); y++){
                if(jugador.getTablero()[x][y] != null){
                    Barco barco = jugador.getTablero()[x][y];
                    if (Portaaviones.class.equals(barco.getClass())) {
                        System.out.print(barco.getColor()+comprobarDaño(barco,x, y)+ANSI_RESET);
                    } else if (Destructor.class.equals(barco.getClass())) {
                        System.out.print(barco.getColor()+comprobarDaño(barco,x, y)+ANSI_RESET);
                    } else if (Acorazado.class.equals(barco.getClass())) {
                        System.out.print(barco.getColor()+comprobarDaño(barco,x, y)+ANSI_RESET);
                    } else if (Mina.class.equals(barco.getClass())) {
                        System.out.print(barco.getColor()+comprobarDaño(barco,x, y)+ANSI_RESET);
                    }

                }
                else{
                    System.out.print(ANSI_BLUE+"█"+ANSI_RESET);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private String comprobarDaño(Barco barco, int x, int y){
    int desfase = 0;
    if(barco.getOrientacion() == Orientacion.VERTICAL){
        desfase = y - barco.getY();
    }
    else{
        desfase = x - barco.getX();
    }
    if (barco.getEstado(desfase) == Estado.OK){
        return "█";
    }
    else if (barco.getEstado(desfase) == Estado.TOCADO){
        return "~";
    }
    else if (barco.getEstado(desfase)==Estado.HUNDIDO){
        return "X";
    }
        return null;
    }
}

package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Barcos.Acorazado;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
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
            menuBarcos(jugador);
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
        Barco barco = generate(type, jugador);
        /*
        colocarBarcos(tablero,barco,numPortaaviones,numDestructor,numAcorazados,numMinas,numTotalBarcos);
         */

        if (barco.getOrientacion() == Orientacion.HORIZONTAL){
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (jugador.getTablero()[barco.getX()+e][barco.getY()] != null){
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
                    jugador.getTablero()[barco.getX()+o][barco.getY()] = barco;
                }
                jugador.resta(type);
            }
        }
        else {
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (jugador.getTablero()[barco.getX()][barco.getY()+e] != null){
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
                    jugador.getTablero()[barco.getX()][barco.getY()+o] = barco;
                }
                jugador.resta(type);
            }
        }
        menuBarcos(jugador);


    }

   /* private void colocarBarcos(Barco[][] tablero, Barco barco, int numPortaaviones, int numDestructor, int numAcorazados, int numMinas, int numTotalBarcos){
        if (barco.getOrientacion() == Orientacion.HORIZONTAL){
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (tablero[barco.getX()+e][barco.getY()] != null){
                        hueco = false;
                    }
                } catch (Exception exception) {
                    System.out.println("Fuera del tablero");
                    if (tablero == tableroBot){
                        menuBarcosBot();
                    }
                    else menuBarcos();
                }
            }
            if (!hueco){
                System.out.println("no es posible colocar el barco");
            }
            else if (hueco){
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    tablero[barco.getX()+o][barco.getY()] = barco;
                }
                if(barco.getClass()==Portaaviones.class) {
                    numPortaaviones--;
                }
                else if(barco.getClass()==Destructor.class) {
                    numDestructor--;
                }
                else if(barco.getClass()==Acorazado.class) {
                    numAcorazados--;
                }
                else if(barco.getClass()==Mina.class) {
                    numMinas--;
                }
                numTotalBarcos--;
            }
        }
        else {
            boolean hueco = true;
            for (int e = 0; e < barco.getNumCeldas(); e++) {
                try {
                    if (tablero[barco.getX()][barco.getY()+e] != null){
                        hueco = false;
                    }
                } catch (Exception exception) {
                    System.out.println("fuera del tablero");
                    if (tablero == tableroBot){
                        menuBarcosBot();
                    }
                    else menuBarcos();
                }

            }
            if (!hueco){
                System.out.println("no es posible colocar el barco");
            }
            else if (hueco){
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    tablero[barco.getX()][barco.getY()+o] = barco;
                }
                if(barco.getClass()==Portaaviones.class) {
                    numPortaaviones--;
                }
                else if(barco.getClass()==Destructor.class) {
                    numDestructor--;
                }
                else if(barco.getClass()==Acorazado.class) {
                    numAcorazados--;
                }
                else if(barco.getClass()==Mina.class) {
                    numMinas--;
                }

                numTotalBarcos--;
            }
        }
        if (tablero == tableroBot){
            menuBarcosBot();
        }
        else menuBarcos();
    }


    */

private void colocarBarcosBot(Class type, Jugador jugador){
    Barco barco = generateBot(type);
    /*
    colocarBarcos(tableroBot,barco,numPortaavionesBot,numDestructorBot,numAcorazadosBot,numMinasBot,numTotalBarcosBot);

     */

    if (barco.getOrientacion() == Orientacion.HORIZONTAL){
        for (int e = 0; e < barco.getNumCeldas(); e++) {
            /*
            try {
                if (jugador.getTablero()[barco.getX()+e][barco.getY()] != null){
                    hueco = false;
                }
            } catch (Exception exception) {
                System.out.println("Fuera del tablero");
                menuBarcosBot(jugador);
            }

             */
            if(jugador.getTablero().length < barco.getX()+barco.getNumCeldas() || jugador.getTablero()[barco.getX()+e][barco.getY()] != null){
                menuBarcosBot(jugador);
            }
            else {
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()+o][barco.getY()] = barco;
                }
                jugador.resta(type);
            }
        }

    }
    else {
        for (int e = 0; e < barco.getNumCeldas(); e++) {
            /*
            try {
                if (jugador.getTablero()[barco.getX()][barco.getY()+e] != null){
                    hueco = false;
                }
            } catch (Exception exception) {
                System.out.println("fuera del tablero");
                menuBarcosBot(jugador);
            }

             */
            if(jugador.getTablero().length < barco.getY()+barco.getNumCeldas() || jugador.getTablero()[barco.getX()][barco.getY()+e] != null){
                menuBarcosBot(jugador);
            }
            else {
                for (int o = 0; o < barco.getNumCeldas(); o++) {
                    jugador.getTablero()[barco.getX()][barco.getY()+o] = barco;
                }
                jugador.resta(type);
            }
        }

    }
    menuBarcosBot(jugador);


}

private boolean comporbar(Jugador jugador){
    boolean opcion = true;
    for (jugador.getTamTablero())
    return true;
}

    private Barco generate(Class type, Jugador jugador){
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
        System.out.println("tablero jugador");
        System.out.print(" ");
        for (int i = 0; i < jugador.getTamTablero(); i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for(int x = 0; x < jugador.getTamTablero(); x++){
            System.out.print(x+" ");
            for(int y = 0; y < jugador.getTamTablero(); y++){
                if(jugador.getTablero()[y][x] != null){
                    Class<? extends Barco> aClass = jugador.getTablero()[y][x].getClass();
                    if (Portaaviones.class.equals(aClass)) {
                        System.out.print(Portaaviones.getColor() + "█" + ANSI_RESET);
                    } else if (Destructor.class.equals(aClass)) {
                        System.out.print(Destructor.getColor() + "█" + ANSI_RESET);
                    } else if (Acorazado.class.equals(aClass)) {
                        System.out.print(Acorazado.getColor() + "█" + ANSI_RESET);
                    } else if (Mina.class.equals(aClass)) {
                        System.out.print(Mina.getColor() + "█" + ANSI_RESET);
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

    public void mostrarTableroBot(Jugador jugador){
        System.out.println("tablero: "+jugador.getNombre());
        System.out.print(" ");
        for (int i = 0; i < jugador.getTamTablero(); i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for(int x = 0; x < jugador.getTamTablero(); x++){
            System.out.print(x+" ");
            for(int y = 0; y < jugador.getTamTablero(); y++){
                if(jugador.getTablero()[y][x] != null){
                    Class<? extends Barco> aClass = jugador.getTablero()[y][x].getClass();
                    if (Portaaviones.class.equals(aClass)) {
                        System.out.print(Portaaviones.getColor() + "█" + ANSI_RESET);
                    } else if (Destructor.class.equals(aClass)) {
                        System.out.print(Destructor.getColor() + "█" + ANSI_RESET);
                    } else if (Acorazado.class.equals(aClass)) {
                        System.out.print(Acorazado.getColor() + "█" + ANSI_RESET);
                    } else if (Mina.class.equals(aClass)) {
                        System.out.print(Mina.getColor() + "█" + ANSI_RESET);
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
}

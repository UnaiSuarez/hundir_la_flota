package com.company.gestores;

import com.company.clases.Barco;
import com.company.clases.Barcos.Acorazado;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Orientacion;

import javax.net.ssl.SSLContext;
import java.util.Scanner;

public class GestorColocacion {
    private int numTotalBarcos = 10;
    private int numAcorazados = 2;
    private int numMinas = 4;
    private int numDestructor = 3;
    private int numPortaaviones = 1;

    int tamTablero = 10;

    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_BLACK = "\u001B[30m";


    public void colocarBarco(Barco[][] tablero){
        if (numTotalBarcos == 0){
            mostrarTablero(tablero);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elija un barco:");
            System.out.println("1) Portaaviones: "+numPortaaviones);
            System.out.println("2) Destructor: "+numDestructor);
            System.out.println("3) Acorazado: "+numAcorazados);
            System.out.println("4) Minas: "+numMinas);
            System.out.println("5) Salir");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")){
                colocarPortaaviones(tablero);
            }
            else if (opcion.equals("2")){
                colocarDestructor(tablero);
            }
            else if (opcion.equals("3")){
colocarAcorazado(tablero);
            }
            else if (opcion.equals("4")){
colocarMinas(tablero);
            }
            else if (opcion.equals("5")){
mostrarTablero(tablero);
            }
            else {
                System.out.println(opcion+" no es una opcion");
                colocarBarco(tablero);
            }
        }
    }

    public void colocarDestructor(Barco[][] tablero){
        if (numDestructor != 0){
                Scanner scanner = new Scanner(System.in);
                mostrarTablero(tablero);
                System.out.println("Elije una posición:");
                System.out.print("Posicion x:");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.print("Posicion y:");
                int y = Integer.parseInt(scanner.nextLine());
                System.out.print("Orientación:");
                String posicion = scanner.nextLine();
                if (posicion.equals("horizontal")){
                    Barco destructor = new Destructor(x,y, Orientacion.HORIZONTAL);
                    boolean hueco = true;
                    for (int e = 0; e < destructor.getNumCeldas(); e++) {
                        try {
                            if (tablero[destructor.getX()+e][destructor.getY()] != null){
                                hueco = false;
                            }
                        } catch (Exception exception) {
                            System.out.println("Fuera del tablero");
                            colocarBarco(tablero);
                        }

                    }
                    if (hueco == false){
                        System.out.println("no es posible colocar el barco");
                    }
                    else if (hueco == true){
                        for (int o = 0; o < destructor.getNumCeldas(); o++) {
                            tablero[destructor.getX()+o][destructor.getY()] = destructor;
                        }
                        numDestructor--;
                        numTotalBarcos--;
                    }
                }
                else {
                    Barco destructor = new Destructor(x,y,Orientacion.VERTICAL);
                    boolean hueco = true;
                    for (int e = 0; e < destructor.getNumCeldas(); e++) {
                        try {
                            if (tablero[destructor.getX()][destructor.getY()+e] != null){
                                hueco = false;
                            }
                        } catch (Exception exception) {
                            System.out.println("Fuera del tablero");
                            colocarBarco(tablero);
                        }
                    }
                    if (hueco == false){
                        System.out.println("no es posible colocar el barco");
                    }
                    else if (hueco == true){
                        for (int o = 0; o < destructor.getNumCeldas(); o++) {
                            tablero[destructor.getX()][destructor.getY()+o] = destructor;
                        }
                        numDestructor--;
                        numTotalBarcos--;
                    }
                }
        }
        else {
            System.out.println("no te quedan destructores");
        }
        colocarBarco(tablero);
    }

    public void colocarPortaaviones(Barco[][] tablero){
        if (numPortaaviones != 0){
            Scanner scanner = new Scanner(System.in);
            mostrarTablero(tablero);
            System.out.println("Elije una posición:");
            System.out.print("Posicion x:");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("Posicion y:");
            int y = Integer.parseInt(scanner.nextLine());
            System.out.print("Orientación:");
            String posicion = scanner.nextLine();
            if (posicion.equals("horizontal")){
                Barco portaaviones = new Portaaviones(x,y, Orientacion.HORIZONTAL);
                boolean hueco = true;
                for (int e = 0; e < portaaviones.getNumCeldas(); e++) {
                    try {
                        if (tablero[portaaviones.getX()+e][portaaviones.getY()] != null){
                            hueco = false;
                        }
                    } catch (Exception exception) {
                        System.out.println("Fuera del tablero");
                        colocarBarco(tablero);
                    }
                }
                if (hueco == false){
                    System.out.println("no es posible colocar el barco");
                }
                else if (hueco == true){
                    for (int o = 0; o < portaaviones.getNumCeldas(); o++) {
                        tablero[portaaviones.getX()+o][portaaviones.getY()] = portaaviones;
                    }
                    numPortaaviones--;
                    numTotalBarcos--;
                }
            }
            else {
                Barco portaaviones = new Portaaviones(x,y,Orientacion.VERTICAL);
                boolean hueco = true;
                for (int e = 0; e < portaaviones.getNumCeldas(); e++) {
                    try {
                        if (tablero[portaaviones.getX()][portaaviones.getY()+e] != null){
                            hueco = false;
                        }
                    } catch (Exception exception) {
                        System.out.println("fuera del tablero");
                        colocarBarco(tablero);
                    }

                }
                if (hueco == false){
                    System.out.println("no es posible colocar el barco");
                }
                else if (hueco == true){
                    for (int o = 0; o < portaaviones.getNumCeldas(); o++) {
                            tablero[portaaviones.getX()][portaaviones.getY()+o] = portaaviones;
                    }
                    numPortaaviones--;
                    numTotalBarcos--;
                }
            }
        }
        else {
            System.out.println("no te quedan portaaviones");
        }
        colocarBarco(tablero);
    }


    public void colocarAcorazado(Barco[][] tablero) {
        if (numAcorazados != 0) {
            Scanner scanner = new Scanner(System.in);
            mostrarTablero(tablero);
            System.out.println("Elije una posición:");
            System.out.print("Posicion x:");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("Posicion y:");
            int y = Integer.parseInt(scanner.nextLine());
            System.out.print("Orientación:");
            String posicion = scanner.nextLine();
            if (posicion.equals("horizontal")) {
                Barco acorazado = new Acorazado(x, y, Orientacion.HORIZONTAL);
                boolean hueco = true;
                for (int e = 0; e < acorazado.getNumCeldas(); e++) {
                    try {
                        if (tablero[acorazado.getX() + e][acorazado.getY()] != null) {
                            hueco = false;
                        }
                    } catch (Exception exception) {
                        System.out.println("Fuera del tablero");
                        colocarBarco(tablero);
                    }
                }
                if (hueco == false) {
                    System.out.println("no es posible colocar el barco");
                } else if (hueco == true) {
                    for (int o = 0; o < acorazado.getNumCeldas(); o++) {
                        tablero[acorazado.getX() + o][acorazado.getY()] = acorazado;
                    }
                    numAcorazados--;
                    numTotalBarcos--;
                }
            } else {
                Barco acorazado = new Acorazado(x, y, Orientacion.VERTICAL);
                boolean hueco = true;
                for (int e = 0; e < acorazado.getNumCeldas(); e++) {
                    try {
                        if (tablero[acorazado.getX()][acorazado.getY() + e] != null) {
                            hueco = false;
                        }
                    } catch (Exception exception) {
                        System.out.println("fuera del tablero");
                        colocarBarco(tablero);
                    }
                    if (hueco == false) {
                        System.out.println("no es posible colocar el barco");
                    } else if (hueco == true) {
                        for (int o = 0; o < acorazado.getNumCeldas(); o++) {
                            tablero[acorazado.getX()][acorazado.getY() + o] = acorazado;
                        }
                        numAcorazados--;
                        numTotalBarcos--;
                    }
                }
            }
        }
        else{
                System.out.println("no te quedan acorazados");
            }
            colocarBarco(tablero);

    }

    public void colocarMinas(Barco[][] tablero){
        if (numMinas != 0){
            Scanner scanner = new Scanner(System.in);
            mostrarTablero(tablero);
            System.out.println("Elije una posición:");
            System.out.print("Posicion x:");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("Posicion y:");
            int y = Integer.parseInt(scanner.nextLine());
            Barco mina = new Mina(x,y, Orientacion.HORIZONTAL);
                boolean hueco = true;
                if (tablero[mina.getX()][mina.getY()] != null){
                    hueco = false;
                }
                if (hueco == false){
                    System.out.println("no es posible colocar el barco");
                }
                else if (hueco == true){
                        tablero[mina.getX()][mina.getY()] = mina;
                    numMinas--;
                    numTotalBarcos--;
                }
        }
        else {
            System.out.println("no te quedan minas");
        }
        colocarBarco(tablero);
    }



    public void mostrarTablero(Barco[][] tablero){
        System.out.print(" ");
        for (int i = 0; i < tamTablero; i++) {
            System.out.print(" "+i);
        }
        System.out.println();
        for(int x = 0; x < tamTablero; x++){
            System.out.print(x+" ");
            for(int y = 0; y < tamTablero; y++){
                if(tablero[y][x] != null){
                    System.out.print(ANSI_BLACK+"▓"+ANSI_RESET);
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

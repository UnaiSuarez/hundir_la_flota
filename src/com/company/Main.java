package com.company;

import com.company.clases.Barco;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Orientacion;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tamTablero = 10;

        Barco[][] tablero = new Barco[tamTablero][tamTablero];

        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elije una posición:");
            System.out.print("Posicion x:");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("Posicion y:");
            int y = Integer.parseInt(scanner.nextLine());
            System.out.print("Orientación:");
            String posicion = scanner.nextLine();
            if (posicion.equals("horizontal")){
                Barco destructor = new Destructor(x,y,Orientacion.HORIZONTAL);
                for (int e = 0; e < destructor.getNumCeldas(); e++) {
                    if (tablero[destructor.getX()][destructor.getY()+e] == null){
                        if (e == e+1){
                            tablero[destructor.getX()][destructor.getY()+e] = destructor;
                        }
                        else {

                        }

                    }
                }
            }
            else {
                Barco destructor = new Destructor(x,y,Orientacion.VERTICAL);
                for (int e = 0; e < destructor.getNumCeldas(); e++){
                    if (tablero[destructor.getX()+e][destructor.getY()] == null){
                        if (e == e+1){
                            tablero[destructor.getX()+e][destructor.getY()] = destructor;
                        }
                        else {

                        }

                    }
                }
            }

            
        }




        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_BLACK = "\u001B[30m";



        for(int x = 0; x < tamTablero; x++){
            for(int y = 0; y < tamTablero; y++){
                if(tablero[y][x] != null){
                    System.out.print(ANSI_BLACK+"▓"+ANSI_RESET);
                }
                else{
                    System.out.print(ANSI_BLUE+"-"+ANSI_RESET);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }


    }


}

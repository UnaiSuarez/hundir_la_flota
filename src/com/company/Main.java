package com.company;

import com.company.clases.Barco;
import com.company.clases.Barcos.Destructor;
import com.company.clases.Barcos.Mina;
import com.company.clases.Barcos.Portaaviones;
import com.company.clases.Jugador;
import com.company.clases.Orientacion;
import com.company.gestores.GestorAtaque;
import com.company.gestores.GestorColocacion;
import com.company.gestores.GestorMenu;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorMenu gestorMenu = new GestorMenu();
        gestorMenu.menu();


    }


}

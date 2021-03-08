package com.company.clases.DAO.dificultad;

import com.company.clases.Dificultad;
import com.company.clases.Partida;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAODificultadSerializable implements DAODificultad{

    public void guardaDificultad(Dificultad dificultad) {
        try {
            FileOutputStream fos = new FileOutputStream("dificultad");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dificultad);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Dificultad dameDificultad(){
        Dificultad dificultad = null;
        try {
            FileInputStream fis = new FileInputStream("dificultad");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dificultad = (Dificultad) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            return Dificultad.FACIL;
        }

        return dificultad;
    }

}

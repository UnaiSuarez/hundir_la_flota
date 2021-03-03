package com.company.clases.DAO.partidas;

import com.company.clases.Partida;

import java.io.*;
import java.util.ArrayList;

public class DAOPartidasSerializable implements DAOPartidas {

    public void guardaPartida(ArrayList<Partida> partida) {
        try {
            FileOutputStream fos = new FileOutputStream("partidas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(partida);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList damePartidas(){
        ArrayList listaPartidas = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("partidas");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaPartidas = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return listaPartidas;
    }

}

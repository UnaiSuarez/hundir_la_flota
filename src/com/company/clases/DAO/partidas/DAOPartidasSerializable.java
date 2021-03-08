package com.company.clases.DAO.partidas;

import com.company.clases.Partida;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPartidasSerializable implements DAOPartidas {

    public void guardaPartida(List<Partida> partida) {
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

    public List<Partida> damePartidas(){
        List<Partida> listaPartidas = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("partidas");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaPartidas = (List<Partida>) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("No existen partidas guardadas");
        }

        return listaPartidas;
    }

}

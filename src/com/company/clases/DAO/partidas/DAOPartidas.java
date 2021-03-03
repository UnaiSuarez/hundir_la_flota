package com.company.clases.DAO.partidas;

import com.company.clases.Partida;
import java.util.ArrayList;

public interface DAOPartidas {

    public void guardaPartida(ArrayList<Partida> partida);
    public ArrayList damePartidas();
}

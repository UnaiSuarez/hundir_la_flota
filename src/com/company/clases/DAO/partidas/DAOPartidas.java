package com.company.clases.DAO.partidas;

import com.company.clases.Partida;
import java.util.ArrayList;
import java.util.List;

public interface DAOPartidas {

    public void guardaPartida(List<Partida> partida);
    public List<Partida> damePartidas();
}

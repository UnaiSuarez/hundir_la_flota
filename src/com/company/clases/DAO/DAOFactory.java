package com.company.clases.DAO;


import com.company.clases.DAO.partidas.DAOPartidas;
import com.company.clases.DAO.partidas.DAOPartidasSerializable;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOPartidas daoPartidas;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPartidas getDaoPartidas() {
        if(daoPartidas == null){
            daoPartidas = new DAOPartidasSerializable();
        }
        return daoPartidas;
    }
}

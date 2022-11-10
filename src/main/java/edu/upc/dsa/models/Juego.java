package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    String idJuego;
    String descripcion;
    int numNiveles;

    private List<Partida> listaPartidas; //lista de partidas de cada juego

    public Juego(String idJuego, String descripcion, int numNiveles) {
        this.idJuego = idJuego;
        this.setDescripcion(descripcion);
        this.setNumNiveles(numNiveles);
        this.listaPartidas = new ArrayList<Partida>();
    }

    public String getIdJuego() {
        return this.idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego=idJuego;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumNiveles() {
        return numNiveles;
    }

    public void setNumNiveles(int singer) {
        this.numNiveles = numNiveles;
    }

    @Override
    public String toString() {
        return "Juego [id="+ idJuego +", descripcion=" + descripcion + ", numNiveles=" + numNiveles +"]";
    }

}
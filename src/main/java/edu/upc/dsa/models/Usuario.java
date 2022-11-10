package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;
import java.util.List;
import java.util.ArrayList;


public class Usuario {
    private String idUsuario;
    private List<Partida> listaPartidas; //lista de partidas que ha jugado
    private String idPartidaActual;


    public Usuario (String idUsuario, String idPartidaActual){
        this.idUsuario = idUsuario;
        this.idPartidaActual = idPartidaActual;
        this.listaPartidas = new ArrayList<Partida>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getIdPartidaActual() {
        return idPartidaActual;
    }

    public void setIdPartidaActual(String idPartidaActual) {
        this.idPartidaActual = idPartidaActual;
    }

    public List<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(List<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
}


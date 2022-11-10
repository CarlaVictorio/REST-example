package edu.upc.dsa.models;
import java.util.List;
import java.util.ArrayList;

public class Partida {

    private String idPartida;
    private String idJuego;
    private String idUsuario;
    private int nivelActual;
    private int puntosAcumulados; //Puntos acumulados de la partida
    private boolean finalizada;

    private List<LN> listaNiveles;

    public Partida (String idPartida, String idJuego, String idUsuario, int nivelActual, int puntosAcumulados, boolean finalizada){
        listaNiveles = new ArrayList<LN>();
        this.idUsuario = idUsuario;
        this.nivelActual=nivelActual;
        this.puntosAcumulados = puntosAcumulados;
        this.finalizada=finalizada;
    }
    public String getIdUsuario (){
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getIdPartida (){
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    public String getIdJuego (){
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public void addLN(String idJuego, String idUsuario, int nivel, int puntos, String fecha) {
        listaNiveles.add(new LN(idJuego, idUsuario, nivel, puntos, fecha));
    };

    public LN getLN(int i) {
        return listaNiveles.get(i);
    };

    public List<LN> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(List<LN> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }

    public int getNivelActual (){
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }
    public int getPuntosAcumulados (){
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }
    public boolean getFinalizada (){
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }


}

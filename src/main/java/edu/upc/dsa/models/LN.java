package edu.upc.dsa.models;

//CLASE PARA LA LISTA DE NIVELES
public class LN {
    private String idJuego;
    private String idUsuario;
    private int nivel;
    private int puntos;
    private String fecha;

    public LN (String idJuego, String idUsuario, int nivel, int puntos, String fecha){
        this.idJuego = idJuego;
        this.idUsuario = idUsuario;
        this.nivel = nivel;
        this.puntos = puntos;
        this.fecha = fecha;
    }
    public String getIdJuego() {return idJuego;}

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getIdUsuario() {return idUsuario;}

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNivel() {return nivel;}

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {return puntos;}

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


}

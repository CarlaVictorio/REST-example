package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface PartidasManager {


    //FUNCIONES QUE VAMOS A IMPLEMENTAR
    /*  Creación de un juego --> addJuego
        inicio partida --> addPartida
        consultar nivel actual segun id usuario --> consultarNivelActual
        consultar puntuacion actual segun id usuario
        pasar de nivel
        finalizar partida
        consultar usuarios segun juego ordenados por puntuacion descendente
        consultar partidas segun usuario
        consultar actividad usuario segun juego
     */

    public void addJuego (String idJuego, String descripcion, int numNiveles);
    public void addPartida(String idPartida, String idJuego, String idUsuario, int nivelActual, int puntosAcumulados, boolean finalizada );
    //poner nivel = 1 y puntos = 50, tener en cuenta si está en una partida o no
    public int consultarNivelActual(String idUsuario);
    //devolver el nivel actual y la partida que está jugando
    public int consultarPuntosActual(String idUsuario);
    //devolver los puntos de la partida en curso

    public void pasarNivel(String idUsuario, int puntos, String fecha);
    //sumar 1 a nivel, si esta en el ultimo nivel, puntos acumulados + 100 y partida finalizada
    public void finalizarPartida(String idUsuario);
    //finalizar la partida actual

    public List<Usuario> jugadores(String idJuego);
    //devuelve una lista con los jugadores del juego por puntuacion descentende

    public List<Partida> partidas(String idUsuario);
    //devuelve lista con las partidas que ha jugado

    public String actividad(String idUsuario, String idJuego);
    //devuelve info de la actividad
    // [ {level: 1, points:5, date: dd-mm-aaaa}, {level:2, points:15, date: dd-mm-aaaa}, {level3:
    //points: 20, date: dd-mm-aaaa}]







}

package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.LN;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Usuario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class PartidasManagerImpl implements PartidasManager {
    private static PartidasManager instance;
    protected List<Juego> listaJuegos;
    protected List<Partida> listaPartidas;
    protected List<Usuario> listaUsuarios;
    protected LN listaNiveles;

    final static Logger logger = Logger.getLogger(PartidasManagerImpl.class);

    private PartidasManagerImpl() {
        this.listaJuegos = new ArrayList<>();
        this.listaPartidas = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public static PartidasManager getInstance() {
        if (instance==null) instance = new PartidasManagerImpl();
        return instance;
    }

    public void addJuego(String idJuego, String descripcion, int numNiveles){
        Juego juego = new Juego(idJuego,descripcion,numNiveles);
        listaJuegos.add(juego);
    }
    public boolean comprobarFinalizada(String idPartida){
        int i = 0;
        boolean encontrado = false;
        Partida partida = null;
        while ((!encontrado) && (i < listaPartidas.size())) {
            partida = listaPartidas.get(i);

            if (partida.getIdPartida().equals(idPartida)) {
                encontrado = true;
            }
            i++;
        }
        if(encontrado){
            return partida.getFinalizada();
        }
        else
            return true; //no se encuentra ninguna partida asi que está libre

    }
    public Usuario devolverUsuario (String idUsuario){
        int i = 0;
        boolean encontrado = false;
        Usuario usuario = null;
        while ((!encontrado) && (i < listaUsuarios.size())) {
            usuario = listaUsuarios.get(i);

            if (usuario.getIdUsuario().equals(idUsuario)) {
                encontrado = true;
            }
            i++;
        }
        if(encontrado){
            return usuario;
        }
        else
            return null;
    }
    public Partida devolverPartida (String idPartida){
        int i = 0;
        boolean encontrado = false;
        boolean libre = true;
        Partida partida = null;
        while ((!encontrado) && (i < listaPartidas.size())) {
            partida = listaPartidas.get(i);

            if (partida.getIdPartida().equals(idPartida)) {
                encontrado = true;
            }
            i++;
        }
        if(encontrado){
            return partida;
        }
        else
            return null;
    }
    public boolean comprobarUsuarioLibre(String idUsuario){
        boolean libre = false;
        Usuario resultado = devolverUsuario(idUsuario);
        if (resultado!=null){
            libre = comprobarFinalizada(resultado.getIdPartidaActual());

        }
        return libre;

    }

    public void addPartida(String idPartida, String idJuego, String idUsuario){

        boolean libre = comprobarUsuarioLibre(idUsuario);
        if(libre){
            Partida partida = new Partida(idPartida, idJuego, idUsuario, 1, 50, false);
        }
    }
    public int consultarNivelActual(String idUsuario){
        Usuario usuario = devolverUsuario(idUsuario);
        String idP = usuario.getIdPartidaActual();
        Partida partida = devolverPartida(idP);
        int nivel = partida.getNivelActual();
        return nivel;
    }

    public int consultarPuntosActual(String idUsuario)
    {
        Usuario usuario = devolverUsuario(idUsuario);
        String idP = usuario.getIdPartidaActual();
        Partida partida = devolverPartida(idP);
        int puntos = partida.getPuntosAcumulados();
        return puntos;
    }

    public void pasarNivel(String idUsuario, int puntos, String fecha)
    {
        Usuario usuario = devolverUsuario(idUsuario);
        String idP = usuario.getIdPartidaActual();
        Partida partida = devolverPartida(idP);
        int nivel = partida.getNivelActual();
        //if esta en el ultimo nivel
        partida.setNivelActual(nivel+1);

    }





























    @Override
    public void deleteTrack(String id) {

        Juego t = this.getTrack(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.tracks.remove(t);

    }

    @Override
    public Juego updateTrack(Juego p) {
        Juego t = this.getTrack(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setSinger(p.getSinger());
            t.setTitle(p.getTitle());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
}
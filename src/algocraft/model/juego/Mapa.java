package algocraft.model.juego;

import algocraft.model.excepciones.PosicionInvalidaException;
import algocraft.model.excepciones.PosicionOcupadaException;
import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {

    private static final int MINIMA_POSICION_COORDENADA_X = 0;
    private static final int MINIMA_POSICION_COORDENADA_Y = 0;
    private static final int MAXIMA_POSICION_COORDENADA_X = 9;
    private static final int MAXIMA_POSICION_COORDENADA_Y = 9;

    private Map<Posicion, Madera> posicionesOcupadasMaderas;
    private Map<Posicion, Piedra> posicionesOcupadasPiedras;
    private Map<Posicion, Metal> posicionesOcupadasMetales;
    private Map<Posicion, Diamante> posicionesOcupadasDiamantes;
    private Map<Posicion, Jugador> posicionesOcupadasJugadores;


    public Mapa() {
        posicionesOcupadasMaderas = new HashMap<>();
        posicionesOcupadasPiedras = new HashMap<>();
        posicionesOcupadasMetales = new HashMap<>();
        posicionesOcupadasDiamantes = new HashMap<>();
        posicionesOcupadasJugadores = new HashMap<>();

    }

    public Map<Posicion,Madera> getPosicionesOcupadasMaderas() {
        return posicionesOcupadasMaderas;
    }
    public Map<Posicion,Piedra> getPosicionesOcupadasPiedras() {
        return posicionesOcupadasPiedras;
    }
    public Map<Posicion,Metal > getPosicionesOcupadasMetales() {
        return posicionesOcupadasMetales;
    }
    public Map<Posicion,Diamante > getPosicionesOcupadasDiamantes() {
        return posicionesOcupadasDiamantes;
    }
    public Map<Posicion,Jugador > getPosicionesOcupadasJugadores() {
        return posicionesOcupadasJugadores;
    }


    public boolean posicionOcupada(Posicion posicion) {
        boolean posicionOcupada = posicionesOcupadasMaderas.containsKey(posicion);
        posicionOcupada |= posicionesOcupadasPiedras.containsKey(posicion);
        posicionOcupada |= posicionesOcupadasMetales.containsKey(posicion);
        posicionOcupada |= posicionesOcupadasDiamantes.containsKey(posicion);
        posicionOcupada |= posicionesOcupadasJugadores.containsKey(posicion);

        return posicionOcupada;
    }

    public void ocuparPosicion(Posicion posicion, Madera madera) {
        validarPosicion(posicion);
        posicionesOcupadasMaderas.put(posicion, madera);
    }
    public void ocuparPosicion(Posicion posicion,Piedra piedra) {
        validarPosicion(posicion);
        posicionesOcupadasPiedras.put(posicion, piedra);
    }
    public void ocuparPosicion(Posicion posicion, Metal metal) {
        validarPosicion(posicion);
        posicionesOcupadasMetales.put(posicion,metal );
    }
    public void ocuparPosicion(Posicion posicion,Diamante diamante) {
        validarPosicion(posicion);
        posicionesOcupadasDiamantes.put(posicion,diamante);
    }
    public void ocuparPosicion(Posicion posicion, Jugador jugador) {
        validarPosicion(posicion);
        posicionesOcupadasJugadores.put(posicion, jugador);
    }

    public void desocuparPosicion(Posicion posicion) {
        posicionesOcupadasMaderas.remove(posicion);
        posicionesOcupadasPiedras.remove(posicion);
        posicionesOcupadasMetales.remove(posicion);
        posicionesOcupadasDiamantes.remove(posicion);
        posicionesOcupadasJugadores.remove(posicion);
    }

    private boolean validarPosicion(Posicion posicion) {
        if(posicion.getCoordenadaX() < MINIMA_POSICION_COORDENADA_X ||
                posicion.getCoordenadaX() > MAXIMA_POSICION_COORDENADA_X){
            throw new PosicionInvalidaException();
        }
        if(posicion.getCoordenadaY() < MINIMA_POSICION_COORDENADA_Y ||
                posicion.getCoordenadaY() > MAXIMA_POSICION_COORDENADA_Y){
            throw new PosicionInvalidaException();
        }
        if(posicionOcupada(posicion)){
            throw new PosicionOcupadaException();
        }
        return true;
    }

    public Posicionable obtenerElementoEnPosicion(Posicion posicion){
        if(posicionesOcupadasMaderas.containsKey(posicion)){
            return posicionesOcupadasMaderas.get(posicion);
        }
        if(posicionesOcupadasPiedras.containsKey(posicion)){
            return posicionesOcupadasPiedras.get(posicion);
        }
        if(posicionesOcupadasMetales.containsKey(posicion)){
            return posicionesOcupadasMetales.get(posicion);
        }
        if(posicionesOcupadasDiamantes.containsKey(posicion)){
            return posicionesOcupadasDiamantes.get(posicion);
        }
        return posicionesOcupadasJugadores.get(posicion);
    }
}

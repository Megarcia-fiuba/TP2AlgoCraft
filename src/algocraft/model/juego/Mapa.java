package algocraft.model.juego;

import algocraft.model.excepciones.PosicionInvalidaException;
import algocraft.model.excepciones.PosicionOcupadaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {

    private static final int MINIMA_POSICION_COORDENADA_X = 0;
    private static final int MINIMA_POSICION_COORDENADA_Y = 0;
    private static final int MAXIMA_POSICION_COORDENADA_X = 9;
    private static final int MAXIMA_POSICION_COORDENADA_Y = 9;

    private Map<Posicion, Posicionable> posicionesOcupadas;

    public Mapa() {
        posicionesOcupadas = new HashMap<>();
    }

    public Map<Posicion, Posicionable> getPosicionesOcupadas() {
        return posicionesOcupadas;
    }

    public boolean posicionOcupada(Posicion posicion) {
        return posicionesOcupadas.containsKey(posicion);
    }

    public void ocuparPosicion(Posicion posicion, Posicionable posicionable) {
        validarPosicion(posicion);
        posicionesOcupadas.put(posicion, posicionable);
    }

    public void desocuparPosicion(Posicion posicion) {
        posicionesOcupadas.remove(posicion);
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
        return posicionesOcupadas.get(posicion);
    }
}

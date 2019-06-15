package algocraft.model.juego;

import algocraft.model.excepciones.PosicionInvalidaException;
import algocraft.model.excepciones.PosicionOcupadaException;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private static final int MINIMA_POSICION_COORDENADA_X = 0;
    private static final int MINIMA_POSICION_COORDENADA_Y = 0;
    private static final int MAXIMA_POSICION_COORDENADA_X = 10;
    private static final int MAXIMA_POSICION_COORDENADA_Y = 10;

    private List<Posicion> posicionesOcupadas;

    public Mapa() {
        posicionesOcupadas = new ArrayList<>();
    }

    public boolean posicionOcupada(Posicion posicion) {
        return posicionesOcupadas.contains(posicion);
    }

    public void ocuparPosicion(Posicion posicion) {
        validarPosicion(posicion);
        posicionesOcupadas.add(posicion);
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

    public void desocuparPosicion(Posicion posicion) {
        posicionesOcupadas.remove(posicion);
    }
}

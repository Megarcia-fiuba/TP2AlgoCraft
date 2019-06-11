package algocraft.juego;

import algocraft.excepciones.PosicionOcupadaException;
import algocraft.materiales.Madera;
import algocraft.materiales.Materializable;

public class Posicion {

    private int coordenadaX;
    private int coordenadaY;
    private boolean ocupado;

    public Posicion(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        ocupado = false;
    }

    public int getCoordenadaX() { return coordenadaX; }

    public int getCoordenadaY() { return coordenadaY; }

    public boolean estaVacio() {
        return !ocupado;
    }
//viola encapsulamiento
    public void intercambioDeEstado() {
        if(!this.estaVacio()){
            throw new PosicionOcupadaException();
        }
        Jugador.getJugador().getPosicion().ocupado = false;
        this.ocupado = true;
    }

    public void ocupar(Materializable materializable){
        ocupado = true;
    }
}

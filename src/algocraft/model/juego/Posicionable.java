package algocraft.model.juego;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.materiales.Materializable;

public abstract class Posicionable {

    protected Posicion posicion;

    public Posicion getPosicion() { return posicion; }

    public abstract String getIconoPath();

    public void chocar(Mapa mapa,Jugador jugador){}

    public void chocar(Mapa mapa,Materializable material){}


    public void recibirGolpe(Hacha hacha) {

    }

    public void recibirGolpe(Pico pico) {

    }

    public void recibirGolpe(PicoFino picoFino) {

    }

}

package algocraft.model.juego;

import algocraft.model.materiales.Materializable;

public abstract class Posicionable {

    protected Posicion posicion;

    public Posicion getPosicion() { return posicion; }

    public abstract String getIconoPath();

    public void chocar(Mapa mapa,Jugador jugador){}

    public void chocar(Mapa mapa,Materializable material){}
}

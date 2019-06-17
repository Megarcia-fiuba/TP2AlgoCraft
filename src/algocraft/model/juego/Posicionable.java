package algocraft.model.juego;

public abstract class Posicionable {

    protected Posicion posicion;

    public Posicion getPosicion() { return posicion; }

    public abstract String getIconoPath();
}

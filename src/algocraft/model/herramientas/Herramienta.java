package algocraft.model.herramientas;

import algocraft.model.juego.Posicionable;

public abstract class Herramienta {


    protected int fuerza;

    public abstract double getDurabilidad();

    public int getFuerza() {
        return fuerza;
    }

    public abstract void usar(Posicionable materializable);

    public abstract String getIconoPath();

    public abstract boolean estaRota();
}

package algocraft.model.herramientas;

import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.materiales.Materializable;

public abstract class Herramienta {


    protected int fuerza;

    public abstract double getDurabilidad();

    public int getFuerza() {
        return fuerza;
    }

    public abstract void usar(Materializable materializable);

    public abstract String getIconoPath();
}

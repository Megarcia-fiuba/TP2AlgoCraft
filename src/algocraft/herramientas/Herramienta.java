package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.herramientas.durabilidad.Durabilidad;

public abstract class Herramienta {

    Durabilidad durabilidad;

    protected int fuerza;

    public int getDurabilidad(){
        return durabilidad.getValor();
    }
    public int getFuerza(){
        return fuerza;
    }

    public abstract void usar(Materializable materializable);
}

package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.Durabilidad;

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

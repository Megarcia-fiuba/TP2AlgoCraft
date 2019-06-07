package algocraft.herramientas;

import algocraft.materiales.Materializable;

public abstract class Herramienta {

    protected int fuerza;

    public abstract double getDurabilidad();
    
    public int getFuerza(){
        return fuerza;
    }

    public abstract void usar(Materializable materializable);

}

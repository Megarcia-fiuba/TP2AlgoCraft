package algocraft.model.herramientas;

import algocraft.model.materiales.Materializable;

public abstract class Herramienta {

    protected String iconoPath = "../view/imagenes/hacha.jpg";

    protected int fuerza;

    public abstract double getDurabilidad();
    
    public int getFuerza(){
        return fuerza;
    }

    public abstract void usar(Materializable materializable);

    public String getIconoPath() {
        return iconoPath;
    }
}

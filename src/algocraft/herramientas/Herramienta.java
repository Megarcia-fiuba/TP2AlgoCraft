package algocraft.herramientas;

import algocraft.materiales.Materializable;

public interface Herramienta {
    int getDurabilidad();

    int getFuerza();

    void usar(Materializable materializable);
}

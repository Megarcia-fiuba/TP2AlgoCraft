package algocraft.herramientas;

import algocraft.materiales.Materializable;

public class PicoFino implements Herramienta {
    private int durabilidad;
    private int fuerza;

    public PicoFino() {
        this.fuerza = 20;
        durabilidad = 1000;
    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad -= materializable.desgastar(this)/10;
        materializable.recibirGolpe(this);
    }
}

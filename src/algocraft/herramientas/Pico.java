package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.materiales.Metal;
import algocraft.materiales.propiedades.Durabilidad;

public class Pico implements Herramienta{
    private int fuerza;
    private Durabilidad durabilidad;

    public Pico(Durabilidad durabilidad) {
        this.durabilidad = durabilidad;
        fuerza = durabilidad.getFuerza(this);
    }

    public int getDurabilidad() {
        return durabilidad.getValor();
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }

    public int romperMaterial(Metal metal) {
        if(durabilidad.romperMaterial(metal)){
            return this.getFuerza();
        }
        return 0;
    }
}

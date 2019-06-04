package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.materiales.Metal;
import algocraft.materiales.propiedades.Durabilidad;

public class Pico extends Herramienta{

    public Pico(Durabilidad durabilidad) {
        this.durabilidad = durabilidad;
        this.fuerza = durabilidad.getFuerza(this);
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

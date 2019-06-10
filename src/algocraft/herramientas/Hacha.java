package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.herramientas.durabilidad.Durabilidad;

public class Hacha extends HerramientaConMaterial {

    public Hacha(Durabilidad durabilidad){
        this.durabilidad = durabilidad;
        this.fuerza = durabilidad.getFuerza(this);
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }
}

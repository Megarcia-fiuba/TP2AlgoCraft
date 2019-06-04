package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.Durabilidad;

public class Hacha extends Herramienta {

    public Hacha(Durabilidad durabilidad){
        this.durabilidad = durabilidad;
        int fue =durabilidad.getFuerza(this);
        this.fuerza = durabilidad.getFuerza(this);
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }

}

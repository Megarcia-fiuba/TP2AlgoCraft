package algocraft.model.herramientas;

import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.utils.MatrizDefinida;

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

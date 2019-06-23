package algocraft.model.herramientas;

import algocraft.model.excepciones.HerramientaRotaException;
import algocraft.model.juego.Posicionable;
import algocraft.model.materiales.Metal;
import algocraft.model.herramientas.durabilidad.Durabilidad;

public class Pico extends HerramientaConMaterial{


    public Pico(Durabilidad durabilidad) {
        this.durabilidad = durabilidad;
        this.fuerza = durabilidad.getFuerza(this);
    }

    @Override
    public void usar(Posicionable materializable) {
        if(this.estaRota()){ throw new HerramientaRotaException();}
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }

    @Override
    public String getIconoPath() {
        return durabilidad.getIconoPath(this);
    }

    public int romperMaterial(Metal metal) {
        if(durabilidad.romperMaterial(metal)){
            return this.getFuerza();
        }
        return 0;
    }
}

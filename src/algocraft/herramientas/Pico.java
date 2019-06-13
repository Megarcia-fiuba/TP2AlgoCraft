package algocraft.herramientas;

import algocraft.materiales.Madera;
import algocraft.materiales.Materializable;
import algocraft.materiales.Metal;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.utils.MatrizDefinida;

public class Pico extends HerramientaConMaterial{

    /**
     * Matriz que representa la forma de un pico, creada con madera
     */
    public static final MatrizDefinida<Materializable> FORMA;

    static{
        FORMA= new MatrizDefinida<>(3,3);
        FORMA.putValor(0,2,new Madera());
        FORMA.putValor(1,2,new Madera());
        FORMA.putValor(2,2,new Madera());
        FORMA.putValor(1,1,new Madera());
        FORMA.putValor(1,0,new Madera());
    }

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

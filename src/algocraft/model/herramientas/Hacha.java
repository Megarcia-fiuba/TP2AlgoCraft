package algocraft.model.herramientas;

import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.herramientas.durabilidad.Durabilidad;
import algocraft.model.utils.MatrizDefinida;

public class Hacha extends HerramientaConMaterial {

    /**
     * Matriz que representa la forma de un hacha, creada con madera
     */
    public static final MatrizDefinida<Materializable> FORMA;

    static{
        FORMA= new MatrizDefinida<>(3,3);
        FORMA.putValor(0,2,new Madera());
        FORMA.putValor(1,2,new Madera());
        FORMA.putValor(0,1,new Madera());
        FORMA.putValor(1,1,new Madera());
        FORMA.putValor(1,0,new Madera());
    }

    public Hacha(Durabilidad durabilidad){
        this.durabilidad = durabilidad;
        this.fuerza = durabilidad.getFuerza(this);
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
        System.out.println("funciona");
    }

    @Override
    public String getIconoPath() {
        return durabilidad.getIconoPath(this);
    }
}

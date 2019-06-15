package algocraft.model.herramientas;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.materiales.*;
import algocraft.model.utils.MatrizDefinida;

public class PicoFino extends Herramienta {

    /**
     * Matriz que representa la forma de un PicoFino
     */
    public static final MatrizDefinida<Materializable> FORMACOMPLETA;

    static{
        FORMACOMPLETA= new MatrizDefinida<>(3,3);
        FORMACOMPLETA.putValor(0,2,new Metal());
        FORMACOMPLETA.putValor(1,2,new Metal());
        FORMACOMPLETA.putValor(2,2,new Metal());
        FORMACOMPLETA.putValor(0,1,new Piedra());
        FORMACOMPLETA.putValor(1,1,new Madera());
        FORMACOMPLETA.putValor(1,0,new Madera());
    }

    private double durabilidad;

	public PicoFino() {
        this.fuerza = 20;
        this.durabilidad = 1000;
    }

    @Override
    public double getDurabilidad() {
        return durabilidad;
    }
    
    @Override
    public void usar(Materializable materializable) {
        materializable.recibirGolpe(this);
    }
    //Consulta: si envio el metodo desgastar con un diamante por parametro siempre va a elegir la segunda  firma y no la primera?(A pesar de que el diamante es un Materializable)
    public void desgastar(Materializable material){

    }

    public void desgastar(Diamante diamante){
        if(durabilidad - durabilidad * 0.1 < 1){
            durabilidad = 0;
            throw new DurabilidadTerminadaException();
        }
        durabilidad -= ( durabilidad * 0.1 );
    }
}

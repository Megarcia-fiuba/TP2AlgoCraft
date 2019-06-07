package algocraft.herramientas;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.materiales.Diamante;
import algocraft.materiales.Materializable;

public class PicoFino extends Herramienta {

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
        materializable.desgastar(this);
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

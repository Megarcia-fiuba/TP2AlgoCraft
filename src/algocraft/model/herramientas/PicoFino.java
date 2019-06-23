package algocraft.model.herramientas;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.excepciones.HerramientaRotaException;
import algocraft.model.juego.Posicionable;
import algocraft.model.materiales.*;

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
    public boolean estaRota() {
        return this.durabilidad<=0;
    }

    @Override
    public void usar(Posicionable materializable) {
        if(this.estaRota()){ throw new HerramientaRotaException();}
	    materializable.recibirGolpe(this);
    }

    @Override
    public String getIconoPath() {
	    return "../view/imagenes/picoFino.png";
    }

    
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

package algocraft.model.materiales;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;

public abstract class Materializable {
    
	protected int durabilidad;
	protected Posicion posicion;

    public void recibirGolpe(Hacha hacha) {
    	
    }

    public void recibirGolpe(Pico pico) {
    	
    }

    public void recibirGolpe(PicoFino picoFino) {
    	
    }

    public double getDurabilidad() {
    	return durabilidad;
    }

    public boolean estaRoto() {
    	return (durabilidad==0);
    }


    abstract boolean mismoMaterial(Materializable otraPieza);

    boolean piezaIgual(Madera madera){
        return false;
    }


    boolean piezaIgual(Piedra piedra){
        return false;
    }

    boolean piezaIgual(Metal metal){
        return false;
    }

    boolean piezaIgual(Diamante diamante){
        return false;
    }

    public void ocuparPosicionEnMapa(Mapa mapa, Posicion posicion) {
        mapa.ocuparPosicion(posicion);
        this.posicion = posicion;
    }
}

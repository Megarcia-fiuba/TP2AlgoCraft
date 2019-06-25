package algocraft.model.materiales;

import algocraft.model.juego.Posicionable;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.herramientas.PicoFino;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;

public abstract class Materializable extends Posicionable {
    
	protected int durabilidad;

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


    public abstract boolean mismoMaterial(Materializable otraPieza);

    public boolean piezaIgual(Madera madera){
        return false;
    }

    public boolean piezaIgual(Piedra piedra){
        return false;
    }

    public boolean piezaIgual(Metal metal){
        return false;
    }

    public boolean piezaIgual(Diamante diamante){
        return false;
    }

    public abstract void ocuparPosicionEnMapa(Mapa mapa, Posicion posicion);
}

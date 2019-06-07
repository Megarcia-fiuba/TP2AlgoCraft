package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public abstract class Materializable {
    
	protected int durabilidad;
	
	public void desgastar(PicoFino picoFino) {
		
	}

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
}

package algocraft.herramientas.durabilidad;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public abstract class Durabilidad{

    protected double valor;

	public double getValor() {
    	return valor;
    }

    public abstract int getFuerza(Hacha hacha);

    public abstract int getFuerza(Pico pico);

    public abstract void desgastar(Hacha hacha);

    public abstract void desgastar(Pico pico);

    public boolean romperMaterial(Metal metal) {
    	return false;
    }

}

package algocraft.model.herramientas.durabilidad;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Metal;

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

    public abstract String getIconoPath(Hacha hacha);

    public abstract String getIconoPath(Pico pico);
}

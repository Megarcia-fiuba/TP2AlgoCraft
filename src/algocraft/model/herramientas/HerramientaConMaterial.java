package algocraft.model.herramientas;

import algocraft.model.herramientas.durabilidad.Durabilidad;

public abstract class HerramientaConMaterial extends Herramienta {

    protected Durabilidad durabilidad;

    public double getDurabilidad() {
        return durabilidad.getValor();
    }

    @Override
    public boolean estaRota() {
        return durabilidad.getValor()<=0;
    }
}

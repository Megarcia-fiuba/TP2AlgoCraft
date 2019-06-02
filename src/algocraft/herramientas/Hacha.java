package algocraft.herramientas;

import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.Durabilidad;

public class Hacha implements Herramienta {

    private Durabilidad durabilidad;
    private int fuerza;

    public Hacha(Durabilidad durabilidad){
        this.durabilidad = durabilidad;
        fuerza = durabilidad.getFuerza(this);
    }
    public int getDurabilidad() {
        return durabilidad.getValor();
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fuerza;
        result = prime * result + getDurabilidad();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hacha other = (Hacha) obj;
        if (this.fuerza != other.fuerza)
            return false;
        if (!durabilidad.equals(other.durabilidad))
            return false;
        return true;
    }

}

package algocraft.materiales.propiedades;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Metal;

public class DurabilidadMadera implements Durabilidad{
    private int valor;

    public DurabilidadMadera(){
        valor = 100;
    }
    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 2;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 2;
    }

    @Override
    public void desgastar(Hacha hacha) {
        valor -= 2;
    }

    @Override
    public void desgastar(Pico pico) {
        valor -= 2;
    }

    @Override
    public boolean romperMaterial(Metal metal) {
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + valor;
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
        DurabilidadMadera other = (DurabilidadMadera) obj;
        if (this.valor != other.valor)
            return false;
        return true;
    }
}

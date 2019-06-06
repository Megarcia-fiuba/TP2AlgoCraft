package algocraft.herramientas.durabilidad;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public class DurabilidadPiedra implements Durabilidad {
    private double valor;

    public DurabilidadPiedra() {
        valor = 200.0;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 5;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 4;
    }

    @Override
    public void desgastar(Hacha hacha) {
        valor -= 5;
    }

    @Override
    public void desgastar(Pico pico) {
        valor -= 4/1.5;
    }

    @Override
    public boolean romperMaterial(Metal metal) {

        return true;
    }

    @Override
    public boolean romperMaterial(Diamante diamante) {
        return false;
    }
}

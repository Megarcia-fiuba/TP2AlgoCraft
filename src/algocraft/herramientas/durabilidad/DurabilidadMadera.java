package algocraft.herramientas.durabilidad;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
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
    public boolean romperMaterial(Diamante diamante) {
        return false;
    }
}

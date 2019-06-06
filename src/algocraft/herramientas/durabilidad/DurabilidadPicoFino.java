package algocraft.herramientas.durabilidad;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public class DurabilidadPicoFino implements Durabilidad {

    private double valor;

    public DurabilidadPicoFino(){
        this.valor=1000;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 0;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 0;
    }

    @Override
    public void desgastar(Hacha hacha) {

    }

    @Override
    public void desgastar(Pico pico) {

    }

    @Override
    public boolean romperMaterial(Metal metal) {
        return false;
    }

    public boolean romperMaterial(Diamante diamante){

        valor -= (valor*0.1);

        return true;
    }
}

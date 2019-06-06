package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public class DurabilidadMadera implements Durabilidad{
    private double valor;

    public DurabilidadMadera(){
        valor = 100.0;
    }
    @Override
    public double getValor() {
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
        if( valor - 2 < 0 ){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 2;
    }

    @Override
    public void desgastar(Pico pico) {
        if( valor - 2 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
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

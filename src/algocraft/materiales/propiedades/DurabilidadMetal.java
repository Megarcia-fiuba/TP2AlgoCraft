package algocraft.materiales.propiedades;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Metal;

public class DurabilidadMetal implements Durabilidad {
    private int valor;
    private int usos;

    public DurabilidadMetal() {
        valor = 400;
        usos = 10;
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 10;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 12;
    }

    @Override
    public void desgastar(Hacha hacha) {
        valor -=  5;
    }

    @Override
    public void desgastar(Pico pico) {
        usos--;
        if(usos <= 0){
            valor = 0;
        }
    }

    @Override
    public boolean romperMaterial(Metal metal) {
        return false;
    }
}

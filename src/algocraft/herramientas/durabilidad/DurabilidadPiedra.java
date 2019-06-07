package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public class DurabilidadPiedra extends Durabilidad {
    public DurabilidadPiedra() {
        valor = 200.0;
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
        if( valor - 5 < 0) {
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 5;
    }

    @Override
    public void desgastar(Pico pico) {
        if( valor - 4/1.5 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -= 4/1.5;
    }

    @Override
    public boolean romperMaterial(Metal metal) {
        return true;
    }
}

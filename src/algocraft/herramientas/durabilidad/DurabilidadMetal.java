package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

public class DurabilidadMetal extends Durabilidad {
    private int usos;

    public DurabilidadMetal() {
        valor = 400.0;
        usos = 10;
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
        if(valor - 5 < 0){
            valor = 0;
            throw new DurabilidadTerminadaException();
        }
        valor -=  5.0;
    }

    @Override
    public void desgastar(Pico pico) {
        if(valor == 0){
            throw new DurabilidadTerminadaException();
        }

        usos--;
        if(usos <= 0){
            valor = 0.0;
        }
    }
}

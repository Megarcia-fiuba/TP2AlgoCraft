package algocraft.model.herramientas.durabilidad;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Metal;
import algocraft.model.utils.MatrizDefinida;

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

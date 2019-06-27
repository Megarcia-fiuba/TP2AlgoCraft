package algocraft.model.herramientas.durabilidad;

import algocraft.model.excepciones.DurabilidadTerminadaException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Pico;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import algocraft.model.utils.MatrizDefinida;

public class DurabilidadMadera extends Durabilidad{


    public DurabilidadMadera(){
        valor = 100.0;
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

}

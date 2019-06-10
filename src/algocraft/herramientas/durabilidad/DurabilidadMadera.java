package algocraft.herramientas.durabilidad;

import algocraft.excepciones.DurabilidadTerminadaException;
import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Diamante;
import algocraft.materiales.Metal;

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

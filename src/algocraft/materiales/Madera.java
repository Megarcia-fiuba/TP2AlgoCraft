package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public class Madera extends Materializable {

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {
        durabilidad -= hacha.getFuerza();
    }
}

package algocraft.materiales;

import algocraft.herramientas.PicoFino;

public class Diamante extends Materializable {

    public Diamante(){
        durabilidad = 100;
    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {
        durabilidad -= picoFino.getFuerza();
        picoFino.desgastar(this);
    }
}

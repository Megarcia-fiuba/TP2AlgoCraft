package algocraft.materiales;

import algocraft.herramientas.PicoFino;

public class Diamante extends Materializable {

    public Diamante(){
        durabilidad = 100;
    }
    @Override
    public void desgastar(PicoFino picoFino) {
        picoFino.desgastar(this);
    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {
        durabilidad -= picoFino.getFuerza();
    }
}

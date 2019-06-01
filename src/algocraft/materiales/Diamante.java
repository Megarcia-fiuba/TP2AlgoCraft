package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public class Diamante implements Materializable {
    private int durabilidad;

    public Diamante(){
        durabilidad = 100;
    }
    @Override
    public int desgastar(PicoFino picoFino) {
        return picoFino.getFuerza();
    }

    @Override
    public void recibirGolpe(Hacha hacha) {

    }

    @Override
    public void recibirGolpe(Pico pico) {

    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {
        durabilidad -= picoFino.getFuerza();
    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }
}

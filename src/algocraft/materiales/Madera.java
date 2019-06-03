package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public class Madera implements Materializable {
    private int durabilidad;

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public int desgastar(PicoFino picoFino) {
        return 0;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {
        durabilidad -= hacha.getFuerza();
    }

    @Override
    public void recibirGolpe(Pico pico) {

    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {

    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }
}

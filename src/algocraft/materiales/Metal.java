package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public class Metal implements Materializable {
    private int durabilidad;

    public Metal(){
        durabilidad = 50;
    }

    @Override
    public int desgastar(PicoFino picoFino) {
        return 0;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {

    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.romperMaterial(this);
    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {

    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }
}

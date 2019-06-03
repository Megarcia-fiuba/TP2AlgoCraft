package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public class Piedra implements Materializable {
    private int durabilidad;

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public int desgastar(PicoFino picoFino) {
        return 0;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {
    	System.out.println("No es posible usar un Hacha para romper una Piedra");
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.getFuerza();
    }

    @Override
    public void recibirGolpe(PicoFino picoFino) {

    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }
}

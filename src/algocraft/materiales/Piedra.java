package algocraft.materiales;

import algocraft.herramientas.Pico;

public class Piedra extends Materializable {

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.getFuerza();
    }
}

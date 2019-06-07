package algocraft.materiales;

import algocraft.herramientas.Pico;

public class Metal extends Materializable {
	
    public Metal(){
        durabilidad = 50;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.romperMaterial(this);
    }
}

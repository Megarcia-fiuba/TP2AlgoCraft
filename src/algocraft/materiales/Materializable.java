package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;

public interface Materializable {
    int desgastar(PicoFino picoFino);

    void recibirGolpe(Hacha hacha);

    void recibirGolpe(Pico pico);

    void recibirGolpe(PicoFino picoFino);

    int getDurabilidad();
}

package algocraft.materiales.propiedades;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.materiales.Metal;

public interface Durabilidad{

    int getValor();

    int getFuerza(Hacha hacha);

    int getFuerza(Pico pico);

    void desgastar(Hacha hacha);

    void desgastar(Pico pico);

    boolean romperMaterial(Metal metal);
}

package algocraft.materiales.propiedades;

public interface Durabilidad{

    int getValor();

    int getFuerza(Hacha hacha);

    int getFuerza(Pico pico);

    void desgastar(Hacha hacha);

    void desgastar(Pico pico);

    boolean romperMaterial(Metal metal);
}

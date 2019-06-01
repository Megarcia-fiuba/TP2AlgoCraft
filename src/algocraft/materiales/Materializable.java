package algocraft.materiales;

public interface Materializable {
    int desgastar(PicoFino picoFino);

    void recibirGolpe(Hacha hacha);

    void recibirGolpe(Pico pico);

    void recibirGolpe(PicoFino picoFino);

    int getDurabilidad();
}

package algocraft.materiales.propiedades;

public class DurabilidadPiedra implements Durabilidad {
    private int valor;

    public DurabilidadPiedra() {
        valor = 200;
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public int getFuerza(Hacha hacha) {
        return 5;
    }

    @Override
    public int getFuerza(Pico pico) {
        return 4;
    }

    @Override
    public void desgastar(Hacha hacha) {
        valor -= 5;
    }

    @Override
    public void desgastar(Pico pico) {
        valor -= (int)(4/1.5);
    }

    @Override
    public boolean romperMaterial(Metal metal) {

        return true;
    }
}

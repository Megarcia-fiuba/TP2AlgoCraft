package algocraft.herramientas;

public class Hacha implements Herramienta{

    private Durabilidad durabilidad;
    private int fuerza;

    public Hacha(Durabilidad durabilidad){
        this.durabilidad = durabilidad;
        fuerza = durabilidad.getFuerza(this);
    }
    public int getDurabilidad() {
        return durabilidad.getValor();
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void usar(Materializable materializable) {
        durabilidad.desgastar(this);
        materializable.recibirGolpe(this);
    }
}

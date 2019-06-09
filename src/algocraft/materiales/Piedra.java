package algocraft.materiales;

import algocraft.herramientas.Pico;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.herramientas.durabilidad.DurabilidadPiedra;

public class Piedra extends Materializable implements PiezaDeConstruccionHerramientas{

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.getFuerza();
    }

    @Override
    public boolean sirveParaMango() {
        return false;
    }

    @Override
    public boolean mismoMaterial(PiezaDeConstruccionHerramientas otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Madera madera) {
        return false;
    }

    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public Durabilidad obtenerTipoDurabilidad() {
        return new DurabilidadPiedra();
    }

    @Override
    public boolean piezaIgual(Piedra piedra) {
        return true;
    }

    @Override
    public boolean piezaIgual(Metal metal) {
        return false;
    }
}

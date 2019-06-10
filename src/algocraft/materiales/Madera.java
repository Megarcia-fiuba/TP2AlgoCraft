package algocraft.materiales;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Pico;
import algocraft.herramientas.PicoFino;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.herramientas.durabilidad.DurabilidadMadera;

public class Madera extends Materializable implements PiezaDeConstruccionHerramientas {

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public void recibirGolpe(Hacha hacha) {
        durabilidad -= hacha.getFuerza();
    }

    @Override
    public boolean sirveParaMango() {
        return true;
    }

    @Override
    public boolean mismoMaterial(PiezaDeConstruccionHerramientas otraPieza) {
        return otraPieza.piezaIgual(this);
    }

    @Override
    public boolean piezaIgual(Madera madera) {
        return true;
    }

    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public Durabilidad obtenerTipoDurabilidad() {
        return new DurabilidadMadera();
    }

    @Override
    public boolean piezaIgual(Piedra piedra) {
        return false;
    }

    @Override
    public boolean piezaIgual(Metal metal) {
        return false;
    }
}

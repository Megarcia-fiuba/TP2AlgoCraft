package algocraft.materiales;

import algocraft.herramientas.Pico;
import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.herramientas.durabilidad.DurabilidadMetal;

public class Metal extends Materializable implements PiezaDeConstruccionHerramientas{
	
    public Metal(){
        durabilidad = 50;
    }

    @Override
    public void recibirGolpe(Pico pico) {
        durabilidad -= pico.romperMaterial(this);
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
        return new DurabilidadMetal();
    }

    @Override
    public boolean piezaIgual(Piedra piedra) {
        return false;
    }

    @Override
    public boolean piezaIgual(Metal metal) {
        return true;
    }
}

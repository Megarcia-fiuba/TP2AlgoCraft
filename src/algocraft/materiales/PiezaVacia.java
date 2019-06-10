package algocraft.materiales;

import algocraft.herramientas.durabilidad.Durabilidad;

public class PiezaVacia implements PiezaDeConstruccionHerramientas {
    @Override
    public boolean sirveParaMango() {
        return false;
    }

    @Override
    public boolean mismoMaterial(PiezaDeConstruccionHerramientas otraParteSuperior) {
        return false;
    }

    @Override
    public boolean piezaIgual(Madera madera) {
        return false;
    }

    @Override
    public boolean esVacia() {
        return true;
    }
//viola principio de segregacion de interfaces
    @Override
    public Durabilidad obtenerTipoDurabilidad() {
        return null;
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

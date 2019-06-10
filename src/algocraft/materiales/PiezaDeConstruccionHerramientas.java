package algocraft.materiales;

import algocraft.herramientas.durabilidad.Durabilidad;

public interface PiezaDeConstruccionHerramientas {
    boolean sirveParaMango();

    boolean mismoMaterial(PiezaDeConstruccionHerramientas otraPieza);

    boolean piezaIgual(Madera madera);

    boolean esVacia();

    Durabilidad obtenerTipoDurabilidad();

    boolean piezaIgual(Piedra piedra);

    boolean piezaIgual(Metal metal);
}

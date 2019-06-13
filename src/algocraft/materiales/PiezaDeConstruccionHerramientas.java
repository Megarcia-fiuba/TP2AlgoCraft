package algocraft.materiales;

import algocraft.herramientas.durabilidad.Durabilidad;
import algocraft.juego.Mapa;
import algocraft.juego.Posicion;

public interface PiezaDeConstruccionHerramientas {
    boolean sirveParaMango();

    boolean mismoMaterial(PiezaDeConstruccionHerramientas otraPieza);

    boolean piezaIgual(Madera madera);

    boolean esVacia();

    Durabilidad obtenerTipoDurabilidad();

    boolean piezaIgual(Piedra piedra);

    boolean piezaIgual(Metal metal);
}

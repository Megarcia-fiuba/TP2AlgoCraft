package algocraft.model.juego;


import algocraft.model.herramientas.constructor.MesaDeConstruccion;
import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;

public class Juego {

    private Jugador jugador;
    private Mapa mapa;
    private MesaDeConstruccion mesa;

    public Juego(Mapa mapa, Jugador jugador) {
        this.jugador = jugador;
        this.mesa = new MesaDeConstruccion();
        this.mapa = mapa;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Mapa getMapa() {
        return mapa;
    }
}

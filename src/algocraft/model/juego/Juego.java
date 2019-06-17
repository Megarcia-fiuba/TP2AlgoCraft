package algocraft.model.juego;


import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;

public class Juego {

    private Jugador jugador;
    private Mapa mapa;

    public Juego(Mapa mapa) {
        this.jugador = new Jugador();
        this.mapa = mapa;
        jugador.iniciarEnMapa(mapa);
        for(int i = 0; i < 5; i++){
            new Madera().ocuparPosicionEnMapa(mapa,new Posicion(i,5));
            new Piedra().ocuparPosicionEnMapa(mapa,new Posicion(5,i));
        }
        for(int i = 9; i >5; i--){
            new Madera().ocuparPosicionEnMapa(mapa,new Posicion(i,5));
            new Metal().ocuparPosicionEnMapa(mapa,new Posicion(5,i));
        }
        new Diamante().ocuparPosicionEnMapa(mapa,new Posicion(5,5));
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Mapa getMapa() {
        return mapa;
    }
}

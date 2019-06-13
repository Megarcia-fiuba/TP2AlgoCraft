package algocraft.juego;

import algocraft.materiales.Diamante;
import algocraft.materiales.Madera;
import algocraft.materiales.Metal;
import algocraft.materiales.Piedra;

public class Juego {

    public Juego(Mapa mapa) {
        Jugador.getJugador().iniciarEnMapa(mapa);
        for(int i = 0; i < 5; i++){
            new Madera().ocuparPosicionEnMapa(mapa,new Posicion(i,5));
            new Piedra().ocuparPosicionEnMapa(mapa,new Posicion(5,i));
        }
        for(int i = 10; i >5; i--){
            new Madera().ocuparPosicionEnMapa(mapa,new Posicion(i,5));
            new Metal().ocuparPosicionEnMapa(mapa,new Posicion(5,i));
        }
        new Diamante().ocuparPosicionEnMapa(mapa,new Posicion(5,5));
    }
}

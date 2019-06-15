package algocraft.model.juego;


import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Metal;
import algocraft.model.materiales.Piedra;

public class Juego {

    public Juego(Mapa mapa) {
        Jugador jugador = new Jugador();
        jugador.iniciarEnMapa(mapa);
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

package algocraft.juego;

import algocraft.materiales.Madera;

public class Mapa {

    private Posicion[][] posiciones;

    public Mapa(){
        posiciones = new Posicion[10][10];
        for(int i = 0; i < 10 ; i++){
            for(int j =  0; j < 10; j++){
                if(i == 0 && j == 0){
                    posiciones[i][j] = Jugador.getJugador().getPosicion();
                }
                posiciones[i][j] = new Posicion(i,j);
            }
        }
        posiciones[1][0].ocupar(new Madera());
    }

    public  Posicion obtenerPosicionSuperior(Posicion posicion) {
        return posiciones[posicion.getCoordenadaX()][posicion.getCoordenadaY() + 1];
    }

    public Posicion obtenerPosicionDerecha(Posicion posicion) {
        return posiciones[posicion.getCoordenadaX() + 1][posicion.getCoordenadaY()];
    }
}

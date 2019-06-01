package algocraft.juego;

public class Jugador {


    private static Jugador JUGADOR = new Jugador();
    
    private Jugador(){
    }

    public static Jugador getJugador() {
        return JUGADOR;
    }
}

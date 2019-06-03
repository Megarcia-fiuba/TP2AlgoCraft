package algocraft.juego;

import algocraft.herramientas.Herramienta;
import algocraft.herramientas.HerramientaInicializable;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private static Jugador JUGADOR = null;
    private List<Herramienta> herramientas;
    private Posicion posicion;
    
    private Jugador(HerramientaInicializable herramienta){
        herramientas = new ArrayList<>();
        posicion = new Posicion(0,0);
        herramientas.add(herramienta);
    }

    public static Jugador getInstance(HerramientaInicializable herramienta) { 
    	if(JUGADOR == null) {
    		JUGADOR = new Jugador(herramienta);
    	}
    	return JUGADOR; }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Posicion getPosicion() { return posicion; }
    
    public static void eliminarJugador() {
    	JUGADOR = null; 
    }
}

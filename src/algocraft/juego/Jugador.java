package algocraft.juego;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.herramientas.durabilidad.DurabilidadMadera;
import algocraft.materiales.Materializable;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

    private static final Jugador JUGADOR = new Jugador();
    private Herramienta herramientaEnUso;
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados;
    private Posicion posicion;
    
    private Jugador(){
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        herramientas = new ArrayList<>();
        herramientaEnUso = new Hacha(new DurabilidadMadera());
        herramientas.add(herramientaEnUso);
    }

    public static Jugador getJugador() { return JUGADOR; }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Herramienta getHerramientaEnUso() { return herramientaEnUso; }

    public Posicion getPosicion() { return posicion; }

    public List<Materializable> getMaterialesRecolectados() { return materialesRecolectados; }

	public void usarHacha(Materializable material) {
		if(material.estaRoto()) {
			materialesRecolectados.add(material);
		} else {
			herramientaEnUso.usar(material);
		}
	}

	public void moverArriba(Mapa mapa){
        Posicion nuevaPosicion = mapa.obtenerPosicionSuperior(this.getPosicion());
        nuevaPosicion.intercambioDeEstado();
        posicion = nuevaPosicion;
    }

    public void moverDerecha(Mapa mapa) {
        Posicion nuevaPosicion = mapa.obtenerPosicionDerecha(this.getPosicion());
        nuevaPosicion.intercambioDeEstado();
        posicion = nuevaPosicion;
    }
}

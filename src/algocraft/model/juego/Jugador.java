package algocraft.model.juego;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.Materializable;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private Herramienta herramientaEnUso;
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados;
    private Posicion posicion;
    
    public Jugador(){
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        herramientas = new ArrayList<>();
        herramientaEnUso = new Hacha(new DurabilidadMadera());
        herramientas.add(herramientaEnUso);
    }

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

    public void moverseEnMapa(Mapa mapa, Posicion posicion) {
        mapa.ocuparPosicion(posicion);
        mapa.desocuparPosicion(this.posicion);
        this.posicion = posicion;
    }

    public void iniciarEnMapa(Mapa mapa) {
        mapa.ocuparPosicion(this.posicion);
    }

    public void moverArriba(Mapa mapa) {
        this.moverseEnMapa(mapa,this.posicion.getPosicionSuperior());
    }

    public void moverAbajo(Mapa mapa) {
        this.moverseEnMapa(mapa,this.posicion.getPosicionInferior());
    }

    public void moverDerecha(Mapa mapa) {
        this.moverseEnMapa(mapa,this.posicion.getPosicionDerecha());
    }

    public void moverIzquierda(Mapa mapa) {
        this.moverseEnMapa(mapa,this.posicion.getPosicionIzquierda());

    }
}

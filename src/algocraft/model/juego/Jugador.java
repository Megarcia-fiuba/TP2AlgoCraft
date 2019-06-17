package algocraft.model.juego;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.Materializable;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Posicionable {

    private Herramienta herramientaEnUso;
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados;
    private String iconoPath = "../view/imagenes/jugador.png";
    
    public Jugador() {
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        herramientas = new ArrayList<>();
        herramientaEnUso = new Hacha(new DurabilidadMadera());
        herramientas.add(herramientaEnUso);
    }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Herramienta getHerramientaEnUso() { return herramientaEnUso; }

    public List<Materializable> getMaterialesRecolectados() { return materialesRecolectados; }

    @Override
    public String getIconoPath() { return this.iconoPath; }

    public void usarHacha(Materializable material) {
		if(material.estaRoto()) {
			materialesRecolectados.add(material);
		} else {
			herramientaEnUso.usar(material);
		}
	}

    public void moverseEnMapa(Mapa mapa, Posicion posicion) {
        mapa.ocuparPosicion(posicion, this);
        mapa.desocuparPosicion(this.posicion);
        this.posicion = posicion;
    }

    public void iniciarEnMapa(Mapa mapa) {
        mapa.ocuparPosicion(this.posicion, this);
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
        this.moverseEnMapa(mapa, this.posicion.getPosicionIzquierda());
    }
}

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
    private String iconoPathNorte = "../view/imagenes/jugadorNorte.png";
    private String iconoPathSur = "../view/imagenes/jugadorSur.png";
    private String iconoPathEste = "../view/imagenes/jugadorEste.png";
    private String iconoPathOeste = "../view/imagenes/jugadorOeste.png";
    private Orientacion orientacion;

    
    public Jugador() {
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        orientacion= new Orientacion();
        herramientas = new ArrayList<>();
        herramientaEnUso = new Hacha(new DurabilidadMadera());
        herramientas.add(herramientaEnUso);
    }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Herramienta getHerramientaEnUso() { return herramientaEnUso; }

    public List<Materializable> getMaterialesRecolectados() { return materialesRecolectados; }

    @Override
    public String getIconoPath() {
        if (this.orientacion.getDirecctionY()==0 && this.orientacion.getDireccionX()==1){
            return this.iconoPathEste;
        }else if (this.orientacion.getDirecctionY()==0 && this.orientacion.getDireccionX()==-1){
            return this.iconoPathOeste;
        }else if (this.orientacion.getDirecctionY()==1 && this.orientacion.getDireccionX()==0){
            return this.iconoPathSur;
        }else if (this.orientacion.getDirecctionY()==-1 && this.orientacion.getDireccionX()==0){
            return this.iconoPathNorte;
        }

        return this.iconoPathSur; }

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
        this.orientacion.mirarNorte();
        this.moverseEnMapa(mapa,this.posicion.getPosicionSuperior());
    }

    public void moverAbajo(Mapa mapa) {
        this.orientacion.mirarSur();
        this.moverseEnMapa(mapa,this.posicion.getPosicionInferior());
    }

    public void moverDerecha(Mapa mapa) {
        this.orientacion.mirarEste();
        this.moverseEnMapa(mapa,this.posicion.getPosicionDerecha());
    }

    public void moverIzquierda(Mapa mapa) {
        this.orientacion.miraroeste();
        this.moverseEnMapa(mapa, this.posicion.getPosicionIzquierda());
    }

    public void usarHerramientaContraPosicionable(Mapa mapa){
        this.herramientaEnUso.usar((Materializable) mapa.obtenerElementoEnPosicion(this.posicion.mirandoA(this.orientacion)));
    }
}

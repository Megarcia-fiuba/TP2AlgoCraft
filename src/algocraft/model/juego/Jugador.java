package algocraft.model.juego;

import algocraft.model.excepciones.HerramientaRotaException;
import algocraft.model.excepciones.PosicionOcupadaException;
import algocraft.model.excepciones.SinEquipoException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Posicionable {

    private Herramienta herramientaEnUso;
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados;
    private Orientacion orientacion;

    
    public Jugador(Herramienta herramienta) {
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        orientacion= new Orientacion();
        herramientas = new ArrayList<>();
        herramientaEnUso = herramienta;
        herramientas.add(herramientaEnUso);
    }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Herramienta getHerramientaEnUso() { return herramientaEnUso; }

    public List<Materializable> getMaterialesRecolectados() { return materialesRecolectados; }

    public void usarHacha(Materializable material) {
		if(material.estaRoto()) {
			materialesRecolectados.add(material);
		} else {
			herramientaEnUso.usar(material);
		}
	}

	public void usarHerramienta(Posicionable elemento){
        herramientaEnUso.usar(elemento);
    }

    public void moverseEnMapa(Mapa mapa, Posicion posicion) {
        try {
            mapa.ocuparPosicion(posicion, this);
            mapa.desocuparPosicion(this.posicion);
            this.posicion = posicion;
        }catch(PosicionOcupadaException p){
            Posicionable elemEnMapa = mapa.obtenerElementoEnPosicion(posicion);
            elemEnMapa.chocar(mapa,this);
        }
    }

    @Override
    public void chocar(Mapa mapa, Materializable material) {
        this.materialesRecolectados.add(material);
        moverseEnMapa(mapa,material.getPosicion());
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
        if (this.herramientaEnUso == null) {
            throw new SinEquipoException();
        }
        try {
            Posicionable elementoEnPosicion = mapa.obtenerElementoEnPosicion(this.posicion.mirandoA(this.orientacion));
            if(elementoEnPosicion != null){
                usarHerramienta(elementoEnPosicion);
            }
        } catch (HerramientaRotaException e) {
            this.herramientas.remove(this.herramientaEnUso);
            this.herramientaEnUso = null;
        }
    }

    public void cambiarHerramienta(Herramienta herramienta){
        this.herramientaEnUso=herramienta;
    }

    public void agregarHerramienta(Herramienta herramienta){
        this.herramientas.add(herramienta);
    }
}

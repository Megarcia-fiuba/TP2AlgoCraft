package algocraft.model.juego;

import algocraft.model.excepciones.HerramientaRotaException;
import algocraft.model.excepciones.PosicionOcupadaException;
import algocraft.model.excepciones.SinEquipoException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.materiales.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void usarHerramienta(Posicionable elemento){
        herramientaEnUso.usar(elemento);
    }

    public void moverseEnMapa(Mapa mapa, Posicion posicion) {
        try {
            mapa.ocuparPosicion(posicion, this);
            mapa.desocuparPosicion(this.posicion);
            this.posicion = posicion;
        }catch(PosicionOcupadaException p){
            Posicionable elemEnMapa=mapa.obtenerElementoEnPosicion(posicion);
            elemEnMapa.chocar(mapa,this);
        }
    }

    @Override
    public void chocar(Mapa mapa,Materializable material) {
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
        if(this.herramientaEnUso==null){throw new SinEquipoException();}
        try{
            usarHerramienta( mapa.obtenerElementoEnPosicion(this.posicion.mirandoA(this.orientacion)));
        }catch(HerramientaRotaException e){
            this.herramientas.remove(this.herramientaEnUso);
            this.herramientaEnUso=null;
        }
    }

    public void cambiarHerramienta(Herramienta herramienta){
        this.herramientaEnUso=herramienta;
    }
}

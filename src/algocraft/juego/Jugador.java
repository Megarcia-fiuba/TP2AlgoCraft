package algocraft.juego;

import java.util.ArrayList;
import java.util.List;

import algocraft.herramientas.Herramienta;
import algocraft.herramientas.Hacha;
import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.DurabilidadMadera; 

public class Jugador {


    private static Jugador JUGADOR = new Jugador();
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados; 
    private Posicion posicion;
    
    private Jugador(){
    	
    	materialesRecolectados = new ArrayList<>(); 
    	herramientas = new ArrayList<>();
    	posicion = new Posicion(0,0);
    	herramientas.add(new Hacha(new DurabilidadMadera()));
    }

    public static Jugador getJugador() {
        return JUGADOR;    
    }
    
    public List<Herramienta> getHerramientas() { 
    	return herramientas; 
    } 
    
    public List<Materializable> getMaterialesRecolectados() { 
    	return materialesRecolectados; 
    } 

    public Posicion getPosicion() { 
    	return posicion; 
    }

	public void usarHacha(Materializable material) {
		if(material.getDurabilidad()==0) {
			materialesRecolectados.add(material);
		}
		else {
			herramientas.get(0).usar(material);
		}
	} 
    
    
}

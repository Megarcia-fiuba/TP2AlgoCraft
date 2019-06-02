package algocraft.juego;

import algocraft.herramientas.Hacha;
import algocraft.herramientas.Herramienta;
import algocraft.materiales.Materializable;
import algocraft.materiales.propiedades.DurabilidadMadera;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private static final Jugador JUGADOR = new Jugador();
    private List<Herramienta> herramientas;
    private List<Materializable> materialesRecolectados;
    private Posicion posicion;
    
    private Jugador(){
        materialesRecolectados = new ArrayList<>();
        posicion = new Posicion(0,0);
        herramientas = new ArrayList<>();
        herramientas.add(new Hacha(new DurabilidadMadera()));
    }

    public static Jugador getInstance() { return JUGADOR; }

    public List<Herramienta> getHerramientas() { return herramientas; }

    public Posicion getPosicion() { return posicion; }

    public List<Materializable> getMaterialesRecolectados() { return materialesRecolectados; }
}

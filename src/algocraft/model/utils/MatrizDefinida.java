package algocraft.model.utils;

import algocraft.model.utils.Excepciones.FueraDeRangoException;

import java.lang.reflect.Array;
import java.util.*;

public class MatrizDefinida<T> {

    private Integer limiteX;
    private Integer limiteY;

    private Map<Casillero, T> casilleros;

    public MatrizDefinida(Integer limiteX, Integer limiteY) {
        this.limiteX = limiteX;
        this.limiteY = limiteY;
        this.casilleros= new HashMap<Casillero,T>();
    }

    public void putValor(int x, int y, T valor) {
        if(x<0||y<0||x>=limiteX||y>=limiteY){
            throw new FueraDeRangoException();
        }
        casilleros.put(new Casillero(x,y),valor);
    }

    public T getValor(int x, int y){
        return casilleros.get(new Casillero(x,y));
    }

    public boolean equalShape(MatrizDefinida<T> otraMatriz){
        return otraMatriz.equalShape(this.casilleros);

    }

    public T popValor(int x, int y){
        return casilleros.remove(new Casillero(x,y));
    }

    private boolean equalShape(Map<Casillero,T> otroCasilleros){
        return otroCasilleros.keySet().equals(this.casilleros.keySet());
    }

    public boolean equal(MatrizDefinida<T> otraMatriz){
        return otraMatriz.casilleros.equals(this.casilleros);

    }

    public void vaciar(){
        this.casilleros= new HashMap<Casillero,T>();
    }

    public List<T> obtenerTodos(){
        return new ArrayList<T>(casilleros.values());
    }
}

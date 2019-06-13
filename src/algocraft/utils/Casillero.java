package algocraft.utils;

public class Casillero {

    private Integer posicionX;

    private Integer posicionY;

    public Casillero(Integer posicionX, Integer posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public boolean enFila(int fila){
        return this.posicionX==fila;
    }

    public boolean enColumna(int columna){
        return this.posicionY==columna;
    }

    public Casillero arriba(){
        return new Casillero(this.posicionX,this.posicionY+1);
    }

    public Casillero abajo(){
        return new Casillero(this.posicionX,this.posicionY-1);
    }

    public Casillero izquierda(){
        return new Casillero(this.posicionX-1,this.posicionY);
    }

    public Casillero derecha(){
        return new Casillero(this.posicionX+1,this.posicionY);
    }

    @Override
    public int hashCode()
    {
        return posicionX.hashCode()+posicionY.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        Casillero otro=(Casillero) o;
        return (otro.posicionY==this.posicionY && otro.posicionX==this.posicionX);
    }

}

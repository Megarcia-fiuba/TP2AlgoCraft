package algocraft.model.juego;

public class Posicion {

    private int coordenadaX;
    private int coordenadaY;

    public Posicion(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() { return coordenadaX; }

    public int getCoordenadaY() { return coordenadaY; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + coordenadaX;
        result = prime * result + coordenadaY;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion other = (Posicion) obj;
        if (this.coordenadaX != other.coordenadaX)
            return false;
        if (this.coordenadaY != other.coordenadaY)
            return false;
        return true;
    }

    public Posicion getPosicionSuperior() {
        return new Posicion(this.getCoordenadaX(),this.getCoordenadaY()-1);
    }

    public Posicion getPosicionInferior() {
        return new Posicion(this.getCoordenadaX(),this.getCoordenadaY()+1);
    }

    public Posicion getPosicionDerecha() {
        return new Posicion(this.getCoordenadaX()+1,this.getCoordenadaY());
    }

    public Posicion getPosicionIzquierda() {
        return new Posicion(this.getCoordenadaX()-1,this.getCoordenadaY());
    }

    public Posicion mirandoA(Orientacion orientacion){
        return new Posicion(this.coordenadaX+orientacion.getDireccionX(),this.coordenadaY+orientacion.getDirecctionY());
    }
}

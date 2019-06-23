package algocraft.model.juego;

public class Orientacion {

    private int direccionX;

    private int direccionY;

    /*Por defecto se inicia mirando hacia el sur
     */
    public Orientacion() {
        direccionX=0;
        direccionY=1;
    }

    public void mirarNorte(){
        direccionX=0;
        direccionY=-1;
    }
    public void mirarSur(){
        direccionX=0;
        direccionY=1;
    }
    public void mirarEste(){
        direccionX=1;
        direccionY=0;
    }
    public void miraroeste(){
        direccionX=-1;
        direccionY=0;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public int getDirecctionY() {
        return direccionY;
    }
}

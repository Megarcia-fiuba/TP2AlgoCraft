package algocraft.model.juego;

public class Orientacion {

    private int direccionX;

    private int direcctionY;

    public void mirarNorte(){
        direccionX=0;
        direcctionY=-1;
    }
    public void mirarSur(){
        direccionX=0;
        direcctionY=1;
    }
    public void mirarEste(){
        direccionX=1;
        direcctionY=0;
    }
    public void miraroeste(){
        direccionX=-1;
        direcctionY=0;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public int getDirecctionY() {
        return direcctionY;
    }
}

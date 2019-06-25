package algocraft.controller.Containers;

import algocraft.controller.VistaJuegoController;
import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Orientacion;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public class JugadorContainer {

    private Jugador jugador;

    private Map<String, ImageView> imagenes;

    private String orientacionActual;

    public JugadorContainer(Jugador jugador) {
        this.jugador = jugador;
        this.orientacionActual="Sur";
        this.initJugadorImagenes();
    }


    private void initJugadorImagenes(){
        imagenes=new HashMap<>();
        imagenes.put("Norte",initImage("algocraft/view/imagenes/jugadorNorte.png"));
        imagenes.put("Sur",initImage("algocraft/view/imagenes/jugadorSur.png"));
        imagenes.put("Este",initImage("algocraft/view/imagenes/jugadorEste.png"));
        imagenes.put("Oeste",initImage("algocraft/view/imagenes/jugadorOeste.png"));
    }

    private ImageView initImage(String imagePath){
        ImageView imagen=new ImageView(getClass().getClassLoader()
                .getResource(imagePath).toString());
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        return imagen;
    }

    public ImageView getImageView(){
        return imagenes.get(orientacionActual);
    }

    public void moverNorte(Mapa mapa){
        this.orientacionActual="Norte";
        this.jugador.moverArriba(mapa);
    }

    public void moverSur(Mapa mapa){
        this.orientacionActual="Sur";
        this.jugador.moverAbajo(mapa);
    }

    public void moverEste(Mapa mapa){
        this.orientacionActual="Este";
        this.jugador.moverDerecha(mapa);
    }

    public void moverOeste(Mapa mapa){
        this.orientacionActual="Oeste";
        this.jugador.moverIzquierda(mapa);
    }
}

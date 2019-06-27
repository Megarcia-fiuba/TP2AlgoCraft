package algocraft.controller.containers;

import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.view.MapaView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public class JugadorContainer {

    private Jugador jugador;
    private HerramientaContainer herramientaEnUso;
    private ObservableList<HerramientaContainer> inventarioHerramientas;

    private Map<String, ImageView> imagenes;

    private String orientacionActual;

    public JugadorContainer(Jugador jugador, HerramientaContainer herramienta) {
        this.jugador = jugador;
        this.orientacionActual = "Sur";
        this.herramientaEnUso = herramienta;
        this.inventarioHerramientas = FXCollections.observableArrayList(herramienta);
        this.initJugadorImagenes();
    }

    private void initJugadorImagenes(){
        imagenes=new HashMap<>();
        imagenes.put("Norte", initImage("algocraft/view/imagenes/jugadorNorte.png"));
        imagenes.put("Sur", initImage("algocraft/view/imagenes/jugadorSur.png"));
        imagenes.put("Este", initImage("algocraft/view/imagenes/jugadorEste.png"));
        imagenes.put("Oeste", initImage("algocraft/view/imagenes/jugadorOeste.png"));
    }

    private ImageView initImage(String imagePath){
        ImageView imagen = new ImageView(getClass().getClassLoader()
                .getResource(imagePath).toString());
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        return imagen;
    }

    public ImageView getImageView(){
        return imagenes.get(orientacionActual);
    }

    public HerramientaContainer getHerramientaEnUso() { return herramientaEnUso; }

    public ObservableList<HerramientaContainer> getInventarioHerramientas() { return inventarioHerramientas; }

    public void moverNorte(Mapa mapa){
        this.orientacionActual = "Norte";
        this.jugador.moverArriba(mapa);
    }

    public void moverSur(Mapa mapa){
        this.orientacionActual = "Sur";
        this.jugador.moverAbajo(mapa);
    }

    public void moverEste(Mapa mapa){
        this.orientacionActual = "Este";
        this.jugador.moverDerecha(mapa);
    }

    public void moverOeste(Mapa mapa){
        this.orientacionActual = "Oeste";
        this.jugador.moverIzquierda(mapa);
    }

    public void usarHerramientaContraPosicionable(MapaView mapaView){
        this.jugador.usarHerramientaContraPosicionable(mapaView.getMapa());
    }

    public void ocuparPosicionEnMapa(Mapa mapa){
        this.jugador.iniciarEnMapa(mapa);
    }

    public Posicion getPosicion(){
        return this.jugador.getPosicion();
    }

    public void agregarHerramientaContainer(HerramientaContainer herramienta){
        this.jugador.agregarHerramienta(herramienta.getHerramienta());
        this.inventarioHerramientas.add(herramienta);
    }

    public void cambiarHerramienta(HerramientaContainer herramientaContainer){
        this.jugador.cambiarHerramienta(herramientaContainer.getHerramienta());
        this.herramientaEnUso = herramientaContainer;
    }
}

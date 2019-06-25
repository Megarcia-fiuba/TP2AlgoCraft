package algocraft.controller.containers;

import algocraft.controller.VistaJuegoController;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Materializable;
import javafx.scene.image.ImageView;

public abstract class MaterialContainer extends PosicionableContainer {

    private ImageView entero;
    private ImageView roto;

    protected Materializable material;

    protected void initImages(String imagePath,String rotaImagePath){
        this.entero=new ImageView(VistaJuegoController.class
                .getResource(imagePath).toString());
        entero.setFitHeight(50);
        entero.setFitWidth(50);
        this.roto=new ImageView(VistaJuegoController.class
                .getResource(rotaImagePath).toString());
        roto.setFitHeight(50);
        roto.setFitWidth(50);
    }

    public ImageView getImageView(){
        return material.estaRoto()?getImagenRota():getImagenEntera();
    }

    public ImageView getImagenEntera(){
        return entero;
    }
    public ImageView getImagenRota(){
        return roto;
    }

    public void ocuparPosicionEnMapa(Mapa mapa, Posicion posicion){
        this.material.ocuparPosicionEnMapa(mapa, posicion);
    };

    public Posicion getPosicion(){
        return this.material.getPosicion();
    }
}

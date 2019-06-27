package algocraft.controller.containers;

import algocraft.controller.VistaJuegoController;
import algocraft.model.juego.Mapa;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.Materializable;
import algocraft.model.materiales.Piedra;
import javafx.scene.image.ImageView;

public abstract class MaterialContainer {

    private ImageView entero;
    private ImageView roto;

    protected Materializable material;

    protected void initImages(String imagePath,String rotaImagePath){
        this.entero = initImage(imagePath);
        this.roto = initImage(rotaImagePath);
    }
    private ImageView initImage(String imagePath){
        ImageView imagen = new ImageView(getClass().getClassLoader()
                .getResource(imagePath).toString());
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        return imagen;
    }

    public Materializable getMaterial() {
        return material;
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

    public boolean equals( MaderaContainer madera){return false;}
    public boolean equals( MetalContainer metal){return false;}
    public boolean equals( PiedraContainer piedra){return false;}
    public boolean equals( DiamanteContainer diamante){return false;}
}

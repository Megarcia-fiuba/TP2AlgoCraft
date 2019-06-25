package algocraft.controller.Containers;

import algocraft.controller.VistaJuegoController;
import algocraft.model.materiales.Materializable;
import javafx.scene.image.ImageView;

public abstract class MaterialContainer {

    private ImageView entero;
    private ImageView roto;

    protected Materializable material;

    protected void initImages(String imagePath,String rotaImagePath){
        this.entero=initImage(imagePath);
        this.roto=initImage(rotaImagePath);
    }
    private ImageView initImage(String imagePath){
        ImageView imagen=new ImageView(getClass().getClassLoader()
                .getResource(imagePath).toString());
        imagen.setFitHeight(50);
        imagen.setFitWidth(50);
        return imagen;
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
}

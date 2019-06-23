package algocraft.controller.SubVistas;

import algocraft.controller.VistaJuegoController;
import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Materializable;
import javafx.scene.image.ImageView;

public abstract class MaterialView {

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
}

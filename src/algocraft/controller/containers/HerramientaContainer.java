package algocraft.controller.containers;

import algocraft.model.herramientas.Herramienta;
import javafx.scene.image.ImageView;


public abstract class HerramientaContainer {

    protected Herramienta herramienta;
    protected ImageView icono;
    protected String nombreHerramienta;

    public ImageView getImageView(){
        return this.icono;
    }

    public String getNombreHerramienta(){
        return this.nombreHerramienta;
    }

    public Herramienta getHerramienta() { return this.herramienta; }

    protected void initImage(String imagePath){
        this.icono = new ImageView(getClass().getClassLoader()
                .getResource(imagePath).toString());
    }
}

package algocraft.controller.containers;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;

public class HachaMetalContainer extends HerramientaContainer {

    public HachaMetalContainer(Hacha hacha){
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Metal";
        this.init();
    }

    public HachaMetalContainer(Herramienta hacha){
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Metal";
        this.init();
    }
    private void init() { this.initImage("algocraft/view/imagenes/hachaMetal.jpg");}
}

package algocraft.controller.containers;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;

public class HachaPiedraContainer extends HerramientaContainer {

    public HachaPiedraContainer(Hacha hacha){
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Piedra";
        this.init();
    }

    public HachaPiedraContainer(Herramienta hacha){
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Piedra";
        this.init();
    }

    private void init() { this.initImage("algocraft/view/imagenes/hachaPiedra.jpg");}
}

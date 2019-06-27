package algocraft.controller.containers;

import algocraft.model.herramientas.Hacha;

public class HachaPiedraContainer extends HerramientaContainer {

    public HachaPiedraContainer(Hacha hacha){
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Piedra";
        this.init();
    }

    private void init() { this.initImage("algocraft/view/imagenes/hachaPiedra.jpg");}
}

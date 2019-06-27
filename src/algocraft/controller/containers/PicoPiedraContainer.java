package algocraft.controller.containers;

import algocraft.model.herramientas.Pico;

public class PicoPiedraContainer extends HerramientaContainer {

    public PicoPiedraContainer(Pico pico){
        this.herramienta = pico;
        this.nombreHerramienta = "Pico Piedra";
        this.init();
    }

    private void init() { this.initImage("algocraft/view/imagenes/picoPiedra.png");}
}

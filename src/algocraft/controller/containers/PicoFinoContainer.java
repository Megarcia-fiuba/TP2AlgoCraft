package algocraft.controller.containers;

import algocraft.model.herramientas.PicoFino;

public class PicoFinoContainer extends HerramientaContainer {

    public PicoFinoContainer(PicoFino picoFino){
        this.herramienta = picoFino;
        this.nombreHerramienta = "Pico Fino";
        this.init();
    }

    private void init() { initImage("algocraft/view/imagenes/picoFino.png"); }
}

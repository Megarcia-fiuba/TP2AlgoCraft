package algocraft.controller.containers;

import algocraft.model.herramientas.Pico;

public class PicoMetalContainer extends HerramientaContainer {

    public PicoMetalContainer(Pico pico){
        this.herramienta = pico;
        this.nombreHerramienta = "Pico Metal";
        this.init();
    }

    private void init(){ initImage("algocraft/view/imagenes/picoMetal.png");}
}

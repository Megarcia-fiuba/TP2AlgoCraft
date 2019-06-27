package algocraft.controller.containers;

import algocraft.model.herramientas.Herramienta;
import algocraft.model.herramientas.Pico;

public class PicoMaderaContainer extends HerramientaContainer {

    public PicoMaderaContainer(Pico pico){
        this.herramienta = pico;
        this.nombreHerramienta = "Pico Madera";
        this.init();
    }

    public PicoMaderaContainer(Herramienta pico){
        this.herramienta = pico;
        this.nombreHerramienta = "Pico Madera";
        this.init();
    }

    private void init() {
        this.initImage("algocraft/view/imagenes/picoMadera.png");
    }
}

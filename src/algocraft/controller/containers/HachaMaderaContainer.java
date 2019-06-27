package algocraft.controller.containers;

import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.Herramienta;

public class HachaMaderaContainer extends HerramientaContainer {

    public HachaMaderaContainer(Hacha hacha) {
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Madera";
        this.init();
    }
    public HachaMaderaContainer(Herramienta hacha) {
        this.herramienta = hacha;
        this.nombreHerramienta = "Hacha Madera";
        this.init();
    }

    private void init(){
        this.initImage("algocraft/view/imagenes/hachaMadera.jpg");
    }

}

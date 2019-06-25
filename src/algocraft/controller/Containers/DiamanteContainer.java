package algocraft.controller.Containers;

import algocraft.model.materiales.Diamante;

public class DiamanteContainer extends MaterialContainer {

    public DiamanteContainer() {
        this.material=new Diamante();
        this.init();
    }

    public DiamanteContainer(Diamante diamante) {
        this.material = diamante;
        this.init();
    }

    private void init(){
        this.initImages("algocraft/view/imagenes/diamante.jpg","algocraft/view/imagenes/diamanteRoto.png");
    }
}

package algocraft.controller.containers;

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
        this.initImages("../view/imagenes/diamante.jpg","../view/imagenes/diamanteRoto.png");
    }
}

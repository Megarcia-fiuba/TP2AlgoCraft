package algocraft.controller.SubVistas;

import algocraft.model.materiales.Diamante;
import algocraft.model.materiales.Metal;

public class DiamanteView extends MaterialView {

    public DiamanteView() {
        this.material=new Diamante();
        this.init();
    }

    public DiamanteView(Diamante diamante) {
        this.material = diamante;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/diamante.jpg","../view/imagenes/diamanteRoto.png");
    }
}

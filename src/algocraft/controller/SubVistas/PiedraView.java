package algocraft.controller.SubVistas;

import algocraft.model.materiales.Madera;
import algocraft.model.materiales.Piedra;

public class PiedraView extends MaterialView{

    public PiedraView() {
        this.material=new Piedra();
        this.init();
    }

    public PiedraView(Piedra piedra) {
        this.material = piedra;
        this.init();
    }

    private void init(){
        this.initImages("../view/imagenes/piedra.png","../view/imagenes/piedraRota.png");
    }

}

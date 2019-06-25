package algocraft.controller;

import algocraft.controller.containers.DiamanteContainer;
import algocraft.controller.containers.MaderaContainer;
import algocraft.controller.containers.MetalContainer;
import algocraft.controller.containers.PiedraContainer;
import algocraft.model.materiales.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VistaConstructorController implements Initializable {
   @FXML
    private Button botonRegresar;
   @FXML
    private GridPane grillaMateriales;

    public void handleAccionBotonRegresar(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getEscenaJuego());
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarMateriales();
        this.initLista();
    }

    private void initLista(){
        grillaMateriales.add(new MaderaContainer().getImagenRota(),0,0);
        grillaMateriales.add(new PiedraContainer().getImagenRota(),0,1);
        grillaMateriales.add(new MetalContainer().getImagenRota(),0,2);
        grillaMateriales.add(new DiamanteContainer().getImagenRota(),0,3);
    }
    private void cargarMateriales() {
        List<Materializable> materiales = VistaJuegoController.getJuego().getJugador().getMaterialesRecolectados();
        grillaMateriales.add(contar(new Madera(),materiales),1,0);
        grillaMateriales.add(contar(new Piedra(),materiales),1,1);
        grillaMateriales.add(contar(new Metal(),materiales),1,2);
        grillaMateriales.add(contar(new Diamante(),materiales),1,3);

    }

    private Text contar(Materializable materialAComparar, List<Materializable> materiales){
        Text cantidad= new Text(" X " + materiales.stream().filter(m->m.equals(materialAComparar)).count());
        cantidad.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        return cantidad;
    }
}

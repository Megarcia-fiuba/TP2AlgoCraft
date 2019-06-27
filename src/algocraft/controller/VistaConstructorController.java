package algocraft.controller;

import algocraft.controller.containers.DiamanteContainer;
import algocraft.controller.containers.MaderaContainer;
import algocraft.controller.containers.MetalContainer;
import algocraft.controller.containers.PiedraContainer;
import algocraft.model.materiales.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
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

    @FXML
    private GridPane grillaConstructor;

    public void handleAccionBotonRegresar(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getInstancia().getEscenaJuego());
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarMateriales();
        this.initLista();
        this.initMesa();
    }

    private void initLista() {
        ImageView madera=new MaderaContainer().getImagenRota();
        madera.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = madera.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(madera.getImage());
                db.setContent(content);

                event.consume();
            }
        });
        ImageView piedra= new PiedraContainer().getImagenRota();
        piedra.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = piedra.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(piedra.getImage());
                db.setContent(content);

                event.consume();
            }
        });
        grillaMateriales.add(madera, 0, 0);
        grillaMateriales.add(piedra, 0, 1);
        grillaMateriales.add(new MetalContainer().getImagenRota(), 0, 2);
        grillaMateriales.add(new DiamanteContainer().getImagenRota(), 0, 3);
    }

    private void cargarMateriales() {
        List<Materializable> materiales = VistaJuegoController.getJuego().getJugador().getMaterialesRecolectados();
        grillaMateriales.add(contar(new Madera(), materiales), 1, 0);
        grillaMateriales.add(contar(new Piedra(), materiales), 1, 1);
        grillaMateriales.add(contar(new Metal(), materiales), 1, 2);
        grillaMateriales.add(contar(new Diamante(), materiales), 1, 3);

    }

    private void initAcciones() {
    }

    private void initMesa() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView actual=vacio();
                actual.setOnDragOver(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* data is dragged over the target */
                        System.out.println("onDragOver");

                        /* accept it only if it is  not dragged from the same node
                         * and if it has a string data */
                        if (event.getGestureSource() != actual) {
                            /* allow for both copying and moving, whatever user chooses */
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }

                        event.consume();
                    }
                });
                actual.setOnDragEntered(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* the drag-and-drop gesture entered the target */
                        System.out.println("onDragEntered");
                        /* show to the user that it is an actual gesture target */
                        if (event.getGestureSource() != actual ) {
                            actual.setOpacity(0.5);
                        }

                        event.consume();
                    }
                });
                actual.setOnDragExited(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* mouse moved away, remove the graphical cues */
                        actual.setOpacity(1);

                        event.consume();
                    }
                });
                actual.setOnDragDropped(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                        //Data dropped
                        //If there is an image on the dragboard, read it and use it
                        Dragboard db = event.getDragboard();
                        //let the source know whether the image was successfully transferred and used
                        actual.setImage(db.getImage());
                        event.consume();
                    }
                });
                grillaConstructor.add(actual, i, j);
            }
        }
    }

    private ImageView vacio() {
        ImageView imagen = new ImageView(getClass().getClassLoader()
                .getResource("algocraft/view/imagenes/vacio.png").toString());
        imagen.setFitHeight(100);
        imagen.setFitWidth(100);
        return imagen;
    }

    private Text contar(Materializable materialAComparar, List<Materializable> materiales) {
        Text cantidad = new Text(" X " + materiales.stream().filter(m -> m.equals(materialAComparar)).count());
        cantidad.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        return cantidad;
    }
}

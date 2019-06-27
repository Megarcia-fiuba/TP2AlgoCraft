package algocraft.controller;

import algocraft.controller.containers.*;
import algocraft.controller.containers.factory.HerramientaContainerFactory;
import algocraft.model.excepciones.FormaInvalidaException;
import algocraft.model.herramientas.constructor.MesaDeConstruccion;
import algocraft.model.juego.Posicion;
import algocraft.model.materiales.*;
import algocraft.model.utils.MatrizDefinida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class VistaConstructorController implements Initializable {
    @FXML
    private Button botonRegresar;
    @FXML
    private GridPane grillaMateriales;

    @FXML
    private GridPane grillaConstructor;

    private MesaDeConstruccion mesa;

    private List<Materializable> materiales ;

    private Map<String,MaterialContainer> ejemplaresDeMaterial;

    private MatrizDefinida<Materializable> reflejo;

    public void handleAccionBotonRegresar(ActionEvent actionEvent) throws IOException {
        handleAccionBotonVaciar();
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.setScene(ProveedorEscena.getInstancia().getEscenaJuego());
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarMateriales();
        this.initEjemplares();
        this.initLista();
        this.initMesa();
    }

    private void initEjemplares(){
        ejemplaresDeMaterial=new HashMap<>();
        ejemplaresDeMaterial.put("madera",new MaderaContainer());
        ejemplaresDeMaterial.put("piedra",new PiedraContainer());
        ejemplaresDeMaterial.put("metal",new MetalContainer());
        ejemplaresDeMaterial.put("diamante",new DiamanteContainer());
    }

    private void initLista() {
        setActionDragSource(ejemplaresDeMaterial.get("madera").getImagenRota(),"madera");
        setActionDragSource(ejemplaresDeMaterial.get("piedra").getImagenRota(),"piedra");
        setActionDragSource(ejemplaresDeMaterial.get("metal").getImagenRota(),"metal");
        setActionDragSource(ejemplaresDeMaterial.get("diamante").getImagenRota(),"diamante");
        startLista();
    }

    private void startLista(){

        grillaMateriales.add(ejemplaresDeMaterial.get("madera").getImagenRota(), 0, 0);
        grillaMateriales.add(ejemplaresDeMaterial.get("piedra").getImagenRota(), 0, 1);
        grillaMateriales.add(ejemplaresDeMaterial.get("metal").getImagenRota(), 0, 2);
        grillaMateriales.add(ejemplaresDeMaterial.get("diamante").getImagenRota(), 0, 3);

        grillaMateriales.add(contar(new Madera(), materiales), 1, 0);
        grillaMateriales.add(contar(new Piedra(), materiales), 1, 1);
        grillaMateriales.add(contar(new Metal(), materiales), 1, 2);
        grillaMateriales.add(contar(new Diamante(), materiales), 1, 3);
    }

    private void cargarMateriales() {
        this.materiales = VistaJuegoController.getJuego().getJugador().getMaterialesRecolectados();

    }

    private void actualizarContadoresMateriales(){
        this.grillaMateriales.getChildren().clear();
        this.startLista();
    }

    private void initMesa() {
        this.mesa= VistaJuegoController.getJuego().getMesa();
        this.reflejo=new MatrizDefinida<>(3,3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView actual=vacio();
                setActionsDragTarget(actual);
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

    public void handleAccionBotonConstruir(){
        try {
            HerramientaContainer herramienta = HerramientaContainerFactory.construir(reflejo, mesa.construir());
            VistaJuegoController.getJugadorContainer().agregarHerramientaContainer(herramienta);
        }catch (FormaInvalidaException e){

        }
    }

    public void handleAccionBotonVaciar(){
        materiales.addAll(mesa.recuperarTodos());
        grillaConstructor.getChildren().retainAll(grillaConstructor.getChildren().get(0));
        initMesa();
    }

    public void setActionDragSource(ImageView nodo, String id){
        nodo.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = nodo.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(nodo.getImage());
                content.putString(id);
                db.setContent(content);

                event.consume();
            }
        });
    }

    private void setActionsDragTarget(ImageView nodo){
        nodo.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != nodo) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });
        nodo.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != nodo) {
                    nodo.setOpacity(0.5);
                }

                event.consume();
            }
        });
        nodo.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                nodo.setOpacity(1);
                event.consume();
            }
        });
        nodo.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                //Data dropped
                //If there is an image on the dragboard, read it and use it
                Dragboard db = event.getDragboard();
                //let the source know whether the image was successfully transferred and used
                if(materiales.contains(ejemplaresDeMaterial.get(db.getString()).getMaterial())){
                    int x= grillaConstructor.getColumnIndex(nodo);
                    int y= grillaConstructor.getRowIndex(nodo);
                    int indexMaterial=materiales.indexOf(ejemplaresDeMaterial.get(db.getString()).getMaterial());
                    mesa.putMaterial(x,2-y,materiales.get(indexMaterial));
                    reflejo.putValor(x,2-y,materiales.get(indexMaterial));
                    materiales.remove(indexMaterial);
                    nodo.setImage(db.getImage());
                    actualizarContadoresMateriales();
                }

                event.consume();
            }
        });

    }

}

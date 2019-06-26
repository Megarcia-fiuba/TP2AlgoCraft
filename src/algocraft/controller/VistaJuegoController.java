package algocraft.controller;

import algocraft.controller.containers.JugadorContainer;
import algocraft.controller.containers.MapaContainer;
import algocraft.model.juego.Juego;
import algocraft.model.juego.Mapa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class VistaJuegoController implements Initializable {
    @FXML
    private MapaContainer mapaContainer;
    @FXML
    private Button botonHerramientas;
    @FXML
    private Button botonConstructor;
    @FXML
    private Button botonReiniciar;

    private static Juego juego;
    private JugadorContainer jugador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarJuego();
        actualizarInventario();
    }

    private void inicializarJuego() {
        Mapa mapa = new Mapa();
        juego = new Juego(mapa);
        this.jugador = new JugadorContainer(juego.getJugador());

        this.mapaContainer.inicializar(mapa);
        this.mapaContainer.posicionarJugador(jugador);
    }

    private void actualizarInventario(){
        ImageView herramientaActual=new ImageView(getClass().getResource(juego.getJugador().getHerramientaEnUso().getIconoPath()).toString());
        herramientaActual.setFitHeight(60);
        herramientaActual.setFitWidth(60);
        botonHerramientas.setGraphic(herramientaActual);
    }

    @FXML
    public void handleAccionBotonHerramientas(ActionEvent evento) throws IOException {
        Stage stage = (Stage) botonHerramientas.getScene().getWindow();
        stage.setScene(ProveedorEscena.getInstancia().getEscenaHerramienta());
        stage.show();
    }

    public static Juego getJuego() {
        return juego;
    }

    public void handleAccionBotonConstructorHerramientas(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) botonConstructor.getScene().getWindow();
        stage.setScene(ProveedorEscena.getInstancia().getEscenaConstructor());
        stage.show();
    }

    @FXML
    public void handleOnKeyPress(KeyEvent event) {

        if (event.getCode() == KeyCode.UP) {
            this.jugador.moverNorte(juego.getMapa());
        } else if (event.getCode() == KeyCode.DOWN) {
            this.jugador.moverSur(juego.getMapa());
        } else if (event.getCode() == KeyCode.LEFT) {
            this.jugador.moverOeste(juego.getMapa());
        } else if (event.getCode() == KeyCode.RIGHT) {
            this.jugador.moverEste(juego.getMapa());
        } else if (event.getCode() == KeyCode.C) {
            this.jugador.usarHerramientaContraPosicionable(this.mapaContainer);
        }
        refresh();
        event.consume();
    }

    private void refresh(){
        mapaContainer.refresh();
    }
    
    @FXML
    public void handleAccionBotonReiniciar(ActionEvent evento) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Reiniciar");
        alert.setHeaderText(null);
        String mensaje = "Esta seguro que desea reiniciar juego?";
        alert.setContentText(mensaje);
        Optional <ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK) {
        	Stage stage = (Stage) botonReiniciar.getScene().getWindow();
            stage.setScene(ProveedorEscena.getInstancia().getEscenaReiniciada());
        	stage.show();
        }
    }
    
    @FXML
    public void handleAccionSalir(ActionEvent evento) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        String mensaje = "Esta seguro que desea salir del juego?";
        alert.setContentText(mensaje);
        Optional <ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK) {
        	System.exit(0);
        }        
    }
    
    @FXML
    public void handleAccionAyuda(ActionEvent evento) throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Reglas de Juego:");
        String mensaje = "Mueva al jugador usando las flechas del teclado\nPrecione la letra C para golpear un material\nSeleccione"
        		+ " 'Herramientas' para visuarizar y seleccionar la herramienta deseada\nPara construir una herramienta"
        		+ " seleccion 'Construir'";
        alert.setContentText(mensaje);
        alert.show();
    }
}

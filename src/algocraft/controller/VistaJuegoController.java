package algocraft.controller;

import algocraft.model.juego.Juego;
import algocraft.model.juego.Mapa;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class VistaJuegoController implements Initializable {
    @FXML
    private GridPane grillaMapa;

    private static Juego juego;
    @FXML
    private Button botonHerramientas;
    @FXML
    private Button botonConstructor;
    @FXML
    private Button botonReiniciar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarJuego();
        posicionarElementosEnMapa();
    }

    private void inicializarJuego() {
        this.juego = new Juego(new Mapa());
    }

    private void posicionarElementosEnMapa() {
        Mapa mapa = this.juego.getMapa();

        mapa.getPosicionesOcupadas().forEach((posicion, posicionable) -> {
            ImageView icono = new ImageView(getClass().getResource(posicionable.getIconoPath()).toString());
            icono.setFitHeight(50);
            icono.setFitWidth(50);
            grillaMapa.add(icono, posicion.getCoordenadaX(), posicion.getCoordenadaY());
        });
    }

    @FXML
    public void handleAccionBotonHerramientas(ActionEvent evento) throws IOException {
        Stage stage = (Stage) botonHerramientas.getScene().getWindow();
        stage.setScene(ProveedorEscena.getEscenaHerramienta());
        stage.show();
    }

    public static Juego getJuego() {
        return juego;
    }

    public void handleAccionBotonConstructorHerramientas(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) botonConstructor.getScene().getWindow();
        stage.setScene(ProveedorEscena.getEscenaConstructor());
        stage.show();
    }

    @FXML
    public void handleOnKeyPress(KeyEvent event) {

        if (event.getCode() == KeyCode.UP) {
            juego.getJugador().moverArriba(juego.getMapa());
        } else if (event.getCode() == KeyCode.DOWN) {
            juego.getJugador().moverAbajo(juego.getMapa());
        } else if (event.getCode() == KeyCode.LEFT) {
            juego.getJugador().moverIzquierda(juego.getMapa());
        } else if (event.getCode() == KeyCode.RIGHT) {
            juego.getJugador().moverDerecha(juego.getMapa());
        } else if (event.getCode() == KeyCode.C) {
            juego.getJugador().usarHerramientaContraPosicionable(juego.getMapa());
        }
        grillaMapa.getChildren().retainAll(grillaMapa.getChildren().get(0));
        this.posicionarElementosEnMapa();
        event.consume();
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
            stage.setScene(ProveedorEscena.getEscenaReiniciada());
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

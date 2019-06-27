package algocraft.controller;

import algocraft.controller.containers.*;
import algocraft.controller.utils.HerramientasListCell;
import algocraft.model.excepciones.SinEquipoException;
import algocraft.model.herramientas.Hacha;
import algocraft.model.herramientas.durabilidad.DurabilidadMadera;
import algocraft.model.juego.Juego;
import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import algocraft.view.MapaView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class VistaJuegoController implements Initializable {
    @FXML
    private MapaView mapaView;
    @FXML
    private ComboBox comboHerramientas;
    @FXML
    private Button botonConstructor;
    @FXML
    private Button botonReiniciar;

    private static Juego juego;
    private JugadorContainer jugadorContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarJuego();
        actualizarInventario();
    }

    private void inicializarJuego() {
        Mapa mapa = new Mapa();
        Hacha hachaMadera = new Hacha(new DurabilidadMadera());
        Jugador jugador = new Jugador(hachaMadera);
        HerramientaContainer hachaMaderaContainer = new HachaMaderaContainer(hachaMadera);
        this.jugadorContainer = new JugadorContainer(jugador, hachaMaderaContainer);
        juego = new Juego(mapa, jugador);

        this.mapaView.inicializar(mapa);
        this.mapaView.posicionarJugador(jugadorContainer);
    }

    private void actualizarInventario(){
        comboHerramientas.getItems().clear();
        comboHerramientas.getItems().addAll(this.jugadorContainer.getInventarioHerramientas());
        comboHerramientas.setCellFactory(c -> new HerramientasListCell());
        comboHerramientas.setButtonCell(new HerramientasListCell());
        comboHerramientas.getSelectionModel().select(this.jugadorContainer.getHerramientaEnUso());

    }

    @FXML
    public void handleAccionComboHerramientas(ActionEvent evento) {
        HerramientaContainer herramientaSeleccionada = (HerramientaContainer) comboHerramientas.getSelectionModel().getSelectedItem();
        if(herramientaSeleccionada != null && !herramientaSeleccionada.equals(this.jugadorContainer.getHerramientaEnUso())){
            this.jugadorContainer.cambiarHerramienta((HerramientaContainer) comboHerramientas.getSelectionModel().getSelectedItem());
            actualizarInventario();
        }
        enfocarMapa();
    }

    public void enfocarMapa(){
        this.mapaView.requestFocus();
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
        MediaPlayer reproductor = new MediaPlayer(new Media(getClass().getClassLoader().getResource("algocraft/view/music/Beep_Short_01_Sound_Effect_Mp3_102.mp3").toString()));
        MediaPlayer reproductorCorte = new MediaPlayer(new Media(getClass().getClassLoader().getResource("algocraft/view/music/008722013_prev.mp3").toString()));

        enfocarMapa();

        if (event.getCode() == KeyCode.UP) {
            reproductor.play();
            this.jugadorContainer.moverNorte(juego.getMapa());
        } else if (event.getCode() == KeyCode.DOWN) {
            reproductor.play();
            this.jugadorContainer.moverSur(juego.getMapa());
        } else if (event.getCode() == KeyCode.LEFT) {
            reproductor.play();
            this.jugadorContainer.moverOeste(juego.getMapa());
            reproductor.play();
        } else if (event.getCode() == KeyCode.RIGHT) {
            reproductor.play();
            this.jugadorContainer.moverEste(juego.getMapa());
        } else if (event.getCode() == KeyCode.C) {
            try{
                this.jugadorContainer.usarHerramientaContraPosicionable(this.mapaView);
                reproductorCorte.play();
            } catch(SinEquipoException e){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Ups!");
                alert.setContentText("No hay herramienta en uso!");
                alert.showAndWait();
            }
        }

        refresh();
        event.consume();
    }

    private void refresh(){
        mapaView.refresh();
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
        String mensaje = "Mueva al jugadorContainer usando las flechas del teclado\nPrecione la letra C para golpear un material\nSeleccione"
        		+ " 'Herramientas' para visuarizar y seleccionar la herramienta deseada\nPara construir una herramienta"
        		+ " seleccion 'Construir'";
        alert.setContentText(mensaje);
        alert.show();
    }
}

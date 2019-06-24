package algocraft.view.inicio.eventhandler;


import java.io.IOException;

import algocraft.controller.ProveedorEscena;
import algocraft.model.juego.Juego;
import algocraft.model.juego.Jugador;
import algocraft.model.juego.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BotonIniciarEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
	
	public BotonIniciarEventHandler(Stage stage) throws IOException {
		this.stage = stage;
	}
	
	 @Override
	    public void handle(ActionEvent actionEvent) {
	        
				try {
					stage.setScene(ProveedorEscena.getEscenaJuego());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	        stage.setFullScreenExitHint("");
	        stage.setFullScreen(true);
	    }

}

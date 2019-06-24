package algocraft.view.inicio;

import java.io.IOException;

import algocraft.view.inicio.eventhandler.BotonIniciarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
	
	public ContenedorInicio(Stage stage) {
	
		DropShadow dropShadow = new DropShadow();
		
		Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Courier Bold", FontWeight.BOLD, 96));

        etiqueta.setText("ALGOCRAFT");
        etiqueta.setEffect(dropShadow);
        etiqueta.setTextFill(Color.WHITE);
		
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		BackgroundImage imagenFondo = new BackgroundImage(new Image(
				"file:src/algocraft/view/imagenes/fondo.jpg", 
				 primaryScreenBounds.getWidth(), 
				 primaryScreenBounds.getHeight(), 
				 false, 
				 true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		
		this.setBackground(new Background(imagenFondo));
		
		Button botonIniciar = new Button();
		botonIniciar.setText("COMENZAR");
		botonIniciar.setFont(Font.font("Courier Bold", FontWeight.BOLD, 20));
		botonIniciar.setEffect(dropShadow);
		botonIniciar.setTextFill(Color.GREY);
		botonIniciar.setPrefHeight(60);
		botonIniciar.setPrefWidth(200);
		
		
		BotonIniciarEventHandler botonIniciarEventHandler;
		try {
			botonIniciarEventHandler = new BotonIniciarEventHandler(stage);
			botonIniciar.setOnAction(botonIniciarEventHandler);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//botonIniciar.setOnAction(botonIniciarEventHandler);
		
		Button botonSalir = new Button();
		botonSalir.setText("SALIR");
		botonSalir.setFont(Font.font("Courier Bold", FontWeight.BOLD, 20));
		botonSalir.setEffect(dropShadow);
		botonSalir.setTextFill(Color.GREY);
		botonSalir.setPrefHeight(60);
		botonSalir.setPrefWidth(200);
	
		
		//BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
		//botonSalir.setOnAction(botonSalirEventHandler);
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);
		
		
		this.getChildren().addAll(etiqueta, botonIniciar, botonSalir);
	
	}

}

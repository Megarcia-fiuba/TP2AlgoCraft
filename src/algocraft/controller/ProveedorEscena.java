package algocraft.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;

public class ProveedorEscena{
    private static Scene escenaJuego = null;

    public static Scene getEscenaJuego() throws IOException {
        if(escenaJuego == null){
            escenaJuego = new Scene(FXMLLoader.load(new File("src/algocraft/view/interfaces/VistaJuego.fxml").toURL()));
        }
        return escenaJuego;
    }
    public static Scene getEscenaHerramienta() throws IOException {
        return new Scene(FXMLLoader.load(new File("src/algocraft/view/interfaces/VistaHerramientas.fxml").toURL()));
    }

    public static Scene getEscenaConstructor() throws IOException{
        return  new Scene(FXMLLoader.load(new File("src/algocraft/view/interfaces/VistaConstructor.fxml").toURL()));
    }
}

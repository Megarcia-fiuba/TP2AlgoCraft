package algocraft.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;

public class ProveedorEscena{
    private static Scene escenaJuego = null;

    private static final ProveedorEscena INSTANCIA= new ProveedorEscena();

    private ProveedorEscena(){

    }
    public static ProveedorEscena getInstancia(){
        return INSTANCIA;
    }

    public Scene getEscenaJuego() throws IOException {
        if(escenaJuego == null){
            System.out.println(getClass().getClassLoader().getResource("algocraft/view/interfaces/VistaJuego.fxml"));
            escenaJuego= new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("algocraft/view/interfaces/VistaJuego.fxml")));
        }
        return escenaJuego;
    }


    public Scene getEscenaConstructor() throws IOException{
        return new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("algocraft/view/interfaces/VistaConstructor.fxml")));
    }
    

    public Scene getEscenaReiniciada() throws IOException {
        escenaJuego=null;
        return getEscenaJuego();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package application;

import controller.Controller_In;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author josue
 */
public class Main extends Application {

//Creacion de la ventana Principal
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Vinculamos la el archivo fxml al loader y lo cargamos al root 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignInWindow.fxml"));
        Parent root = loader.load();
        //Inicializa el Controlador SignIn para enviar la primaryStage y el root.
        Controller_In controlador = loader.getController();
        controlador.setStage(primaryStage);
        controlador.initStage(root);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author josue
 */
public class Controller_In implements Initializable {

    @FXML
    private Logger logger;
    @FXML
    private Stage stage;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnSignUp;
    @FXML
    private TextField txtFieldUser;
    @FXML
    private TextField txtFieldPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        btnSignIn.setOnAction(this::hadleButtonSignIn);
    }

    @FXML
    private void hadleButtonSignIn(ActionEvent event) {

        //Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario y contraseña no coincide", ButtonType.OK);
        //alert.show();
        /**
         * No aceptarán espacios ni la password ni el user User podrá tener como
         * máximo 25 caracteres y password podrá tener como máximo 10 caracteres
         * El password permanece encriptada Tanto Password como User podrán
         * tener números, letras y caracteres especiales. Si el usuario y la
         * contraseña cumplen lo anterior dicho se validarán los datos y se
         * meteran en un objeto User que se enviará a la capa de interfaz con el
         * método logIn(User user) Si las credenciales no son validadas se
         * informará con un aviso de error y saltará una excepción Si existe el
         * usuario en la base de datos y la contraseña es correcta te llevará a
         * otra ventana(Ventana Sign out) y esta ventana quedará bloqueada
         *
         */
        //logger.info("hey");
        boolean hayEspacios = false;
        boolean hayLimiteCaracteres = false;
        /* 
             * boolean coincide = false;
             * hayLimiteCaracteres = limitCharacter();
             * coincide = matchUserPass();
             * 
         */
       hayEspacios = noSpace();
       hayLimiteCaracteres = limitCharacter();

        if (!hayEspacios) {
            windowsOut();
        }

    }

    private boolean noSpace() {
        String  user = txtFieldUser.getText();
        String pass = txtFieldPassword.getText();
        String letraU;
        String letraP;
        boolean esta = false;
//este bucle busca si existe un espacio en el String usuario
        for (int i = 0; i < user.length() && !esta; i++) {
            letraU = user.charAt(i) + "";
            if (letraU.equalsIgnoreCase(" ")) {
                esta = true;
            }
        }
//este bucle busca si existe un espacio en el String password
        for (int i = 0; i < pass.length() && !esta; i++) {
            letraP = pass.charAt(i) + "";
            if (letraP.equalsIgnoreCase(" ")) {
                esta = true;
            }
        }

        if (esta) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Hay espacios", ButtonType.OK);
            alert.show();
            System.out.println("Error hay espacios");

        } else {
            System.out.println("No hay espacios");
        }

        return esta;
    }

    private boolean limitCharacter() {
        boolean esta = false;
        if (txtFieldUser.getText().length() >= 25 || txtFieldPassword.getText().length() >= 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Has sobrepasado el limite de Caracteres", ButtonType.OK);
            alert.show();
            esta = true;

        }
        return esta;
    }

    private boolean matchUserPass() {

        boolean coincide = true;
        if (txtFieldUser.getText().toString().equalsIgnoreCase("user") && txtFieldUser.getText().toString().equalsIgnoreCase("pass")) {
            coincide = false;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario y contraseña no coincide", ButtonType.OK);
            alert.show();
        }
        return coincide;
    }

    @FXML
    private void hadleButtonSignUp(WindowEvent event) {
        //logger.info("hey");

    }

    private void windowsOut() {
        try {
            //Navega a la otra ventana cuando el usuario se llega a conectar

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignOutWindow.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

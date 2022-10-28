/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import clases.Client;
import exceptions.NotAceptSpace;
import exceptions.ValidateUserPass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ClientInterface;
import model.ImplementationClient;

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
//Vinculamos los botones para el funcionamiento y sus condiciones
        btnSignIn.setOnAction(this::hadleButtonSignIn);
        btnSignUp.setOnAction(this::hadleButtonSignUp);
        limitPasswordUser();
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
        boolean hayEspacios = true;
        boolean coincide = true;
        Client user= new Client();
        user=saveLogin();

        try {
            coincide = matchUserPass(coincide);

        } catch (ValidateUserPass ex) {
            System.out.println("Usuario y contraseña erroneos");
            Logger.getLogger("Usuario y contraseña erroneos");
        }

        try {
            hayEspacios = noSpace();
        } catch (NotAceptSpace ex) {
            System.out.println("Error hay espacios");
            Logger.getLogger("Error Hay espacios");
        }

        if (!coincide && !hayEspacios) {
        
            windowsOut(user,event);
        }
        if (coincide) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuarios o contraseña Erroneo ", ButtonType.OK);
            alert.show();

        }

    }

    private boolean noSpace() throws NotAceptSpace {
        String user = txtFieldUser.getText();
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
            //Alert alert = new Alert(Alert.AlertType.ERROR, "Hay espacios", ButtonType.OK);
            //alert.show();
            throw new NotAceptSpace("Error Hay espacios");

        }

        return esta;
    }

    private boolean matchUserPass(boolean coincide) throws ValidateUserPass {
        //Comprueba si el user y la pass coinciden con la base de datos
        if (txtFieldUser.getText().toString().equalsIgnoreCase("user") && txtFieldPassword.getText().toString().equalsIgnoreCase("pass")) {
            coincide = false;

        } else {
            coincide = true;
            //Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario y contraseña no coincide", ButtonType.OK);
            //alert.show();
            throw new ValidateUserPass("User o Password Erroneos");
        }
        return coincide;
    }

    @FXML
    private void hadleButtonSignUp(ActionEvent event) {
        //Te llevará a otra Ventana(Ventana Sign up) y esta ventana quedará bloqueada
        try {
            //Navega a la otra ventana cuando el usuario se llega a conectar

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUpWindow.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);

            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(Controller_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void windowsOut(Client user, ActionEvent event) {
        try {
            //Navega a la otra ventana cuando el usuario se llega a conectar

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignOutWindow.fxml"));
            Controller_Log controlador = new Controller_Log();
            controlador.setUsuario(user);
            loader.setController(controlador);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage1 =new Stage();
            stage1.setScene(scene);
            stage1.setTitle("Log In");
            stage1.setResizable(false);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(Controller_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Limitamos el user a 25 caracteres y password a 10 caracteres 

    private void limitPasswordUser() {
        txtFieldUser.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldUser.getText().length() > 25) {
                    txtFieldUser.setText(txtFieldUser.getText().substring(0, 25));

                }

            }

        });

        txtFieldPassword.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldPassword.getText().length() > 10) {
                    txtFieldPassword.setText(txtFieldPassword.getText().substring(0, 10));

                }

            }

        });
    }

    private Client  saveLogin() {
        ImplementationClient login= new ImplementationClient();
        Client user = new Client();
        user.setLogin(txtFieldUser.getText());
        user.setPasswd(txtFieldPassword.getText());
        //login.logIn(user);
         return user; 
    }
}

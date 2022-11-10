/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import clases.AnswerEnumeration;
import clases.Client;
import clases.Message;
import exceptions.NotAceptSpace;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClientInterface;
import model.ImplementationClient;

/**
 *
 * @author josue
 */
public class Controller_In implements Initializable {

    //Variables Creadas para el uso de la ventanas
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
//We link the buttons for operation and their conditions
        btnSignIn.setOnAction(this::hadleButtonSignIn);
        btnSignUp.setOnAction(this::hadleButtonSignUp);
        limitPasswordUser();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
//Receive the root and the scene is created

    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.setTitle("Sign In");
        stage1.show();
    }
    //Validates user and password

    @FXML
    private void hadleButtonSignIn(ActionEvent event) {
        /**
         * No spaces will be accepted neither the password nor the user User can
         * have a maximum of 25 characters and the password can have a maximum
         * of 10 characters. Maximum 25 characters and the password can have a
         * maximum of 10 characters. The password remains encrypted. Both
         * Password and User can have numbers, letters and special characters.
         * have numbers, letters and special characters. If the user and
         * password If the user and the password comply with the above, the data
         * will be validated and If the user and password meet the above, the
         * data will be validated and * entered into a User object that will be
         * sent to the interface layer with the logIn(User user) method. method
         * logIn(User user). If the credentials are not validated, an error
         * message will be * reported. If the credentials are not validated, an
         * error message will be * reported and an exception will be raised.
         * user exists in the database and the password is correct it will take
         * you to another window (Sign out window) and this window will be
         * locked.
         *
         */
        boolean hayEspacios = true;
        Client user = new Client();
        Message respuesta = new Message();
        //Controls the User and Password fields so that they are not empty. 
        if (!txtFieldUser.getText().equalsIgnoreCase("") && !txtFieldPassword.getText().equalsIgnoreCase("")) {
            try {
                //Controls that there are no spaces
                noSpace();
                //Introduce los datos en objeto User
                user.setLogin(txtFieldUser.getText());
                user.setPasswd(txtFieldPassword.getText());
                //Input data into User object
                respuesta.setCliente(user);
                //sends the response object to be parsed and return another updated response 
                respuesta = saveLogin(respuesta);
                //the message Updated, according to its enumeration we see if one or the other is executed
                if (respuesta.getRESPUESTA().equals(AnswerEnumeration.LOGIN)) {
                    //OpenSignOutyWindow sends the User object
                    windowsOut(user);

                } else {
                    //Alert that the user name or password is Wrong
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Usuarios o contraseña Erroneo ", ButtonType.OK);
                    alert.show();
                }
            } catch (NotAceptSpace ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error, No Acepta Espacios", ButtonType.OK);
                alert.show();
                Logger.getLogger("Error Hay espacios");
            }

        } else {
//Alert that there is an Empty Space in User or Password
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error algun campo esta vacio", ButtonType.OK);
            alert.show();
        }
    }

    private void noSpace() throws NotAceptSpace {
        String user = txtFieldUser.getText();
        String pass = txtFieldPassword.getText();
        String letraU;
        String letraP;
        boolean esta = false;
//this loop searches if there is a space in the user String
        for (int i = 0; i < user.length() && !esta; i++) {
            letraU = user.charAt(i) + "";
            if (letraU.equalsIgnoreCase(" ")) {
                esta = true;
            }
        }
//this loop searches if there is a space in the String password
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
    }

    @FXML
    private void hadleButtonSignUp(ActionEvent event) {
//You will be taken to another window (Sign up window) and this window will be locked.
        try {
            //Navigates to the other window when the user logs in.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUpWindow.fxml"));
            Parent root = loader.load();
            Controller_Up controlador = new Controller_Up();
            controlador.setStage(stage);
            controlador.initStage(root);
            txtFieldUser.setText("");
            txtFieldPassword.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Controller_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void windowsOut(Client user) {
        try {
            //Navigates to the SIgnOut window when the user logs in. 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignOutWindow.fxml"));
            Controller_Log controlador = new Controller_Log();
            //Manda el usuario a la ventana destino
            controlador.setUsuario(user);
            loader.setController(controlador);
            Parent root = loader.load();
            controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);
            //When navigating to the other window, we clear the fields of the Sign In Window.
            txtFieldUser.setText("");
            txtFieldPassword.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Controller_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Limit the user to 25 characters and password to 10 characters 

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
//Send the response to the Implementation

    private Message saveLogin(Message respuesta) {
        ClientInterface login = new ImplementationClient();
        respuesta = login.logIn(respuesta);

        return respuesta;
    }

}

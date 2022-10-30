/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clases.Client;

import exceptions.FullNameException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author somor
 */
public class Controller_Up implements Initializable {

    private static final Logger logMsg = Logger.getLogger("gadfadf");

    @FXML
    private Stage stage;

    @FXML
    private Label label;

    @FXML
    private TextField txtFieldLogin;
    @FXML
    private TextField txtFieldFullName;
    @FXML
    private TextField txtFieldGmail;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private PasswordField txtFieldConfrimPassword;
    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnCancel;
    @FXML
    private Label labelLoginError;
    @FXML
    private Label labelFullNameError;
    @FXML
    private Label labelGmailError;
    @FXML
    private Label labelPasswordError;
    @FXML
    private Label labelPasswordLoginError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        start();
        btnSignUp.setOnAction(this::handleButtonSignUp);
        btnCancel.setOnAction(this::handleButtonCancel);

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.showAndWait();

    }

    public void keyReleasedProperty() {

        if (txtFieldLogin.getText().isEmpty() || txtFieldFullName.getText().isEmpty() || txtFieldGmail.getText().isEmpty() || txtFieldPassword.getText().isEmpty() || txtFieldConfrimPassword.getText().isEmpty()) {
            btnSignUp.setDisable(true);

        } else {
            btnSignUp.setDisable(false);
        }
    }

 

    /**
     * Cuando todos los campos estén llenos se habilitará el botón. Se validaran
     * los campos: El campo login: tendrá un máximo de 25 caracteres; podrá
     * tener números,letras, caracteres especiales y no podrá tener espacios. No
     * podrá estar ya registrado en la base de datos. El campo full name: tendra
     * un maximo de 50 caracteres; podra tener solo letras El campo gmail: se
     * comprobará que tiene el formato adecuado y un máximo de 50 caracteres. No
     * podrá estar ya registrado en la base de datos Los campos password y
     * confirm password: tendrás un máximo de 10 caracteres; podrá tener tanto
     * letras como números y caracteres especiales. Los campos password y
     * confirm password deben ser iguales Si los campos Login, Full Name, Gmail,
     * Password y Confirm Password cumplen lo anterior dicho se validaran y se
     * mandaran en un objeto User que se enviará a la capa de interfaz con el
     * método registerUser(User user) Si las credenciales no son validadas se
     * informará con un textLabel encima del campo mal introducido y saltará una
     * excepción según el campo que esté mal introducido Si el registro se ha
     * realizado correctamente se notificará al usuario con un aviso y el cual
     * al cerrarlo le llevará a la ventana de principal (SignIn) esta ventana se
     * cerrará
     *
     */
    @FXML
    private void handleButtonSignUp(ActionEvent event) {
        try {
            checkFullName();
            /**
             * hideAlerts(); if (checkLogin() == false) { logMsg.log(Level.INFO,
             * "login incorrecto "); JOptionPane.showMessageDialog(null, "Login
             * error \n Must have: \n minimum 3 characters length \n no spaces",
             * "Error", JOptionPane.OK_OPTION);
             * labelLoginError.setStyle("-fx-text-fill:RED"); }
             * *
             */
            /**
             * if (checkFullName() == false) { //LOGGER.log(Level.SEVERE,
             * errorMsg); logMsg.log(Level.INFO, "full name incorrecto ");
             * JOptionPane.showMessageDialog(null, "Full name error \n Must
             * have: \n minimum 8 letters length", "Error",
             * JOptionPane.OK_OPTION);
             * labelFullNameError.setStyle("-fx-text-fill:RED"); } else if
             * (checkEmail() == false) { logMsg.log(Level.INFO, "email
             * incorrecto "); JOptionPane.showMessageDialog(null, "Email format
             * incorrect \n Example: andrew@example.com", "Error",
             * JOptionPane.OK_OPTION);
             * labelGmailError.setStyle("-fx-text-fill:RED"); } else if
             * (checkPassword() == false) { logMsg.log(Level.INFO, "password
             * incorrecto"); JOptionPane.showMessageDialog(null, "Password error
             * \nMust have: \n minimum 4 characters length", "Error",
             * JOptionPane.OK_OPTION);
             * labelPasswordError.setStyle("-fx-text-fill:RED"); } else if
             * (checkConfirmPasword() == false) { logMsg.log(Level.INFO,
             * "confirm password incorrecto");
             * JOptionPane.showMessageDialog(null, "\"Password Confirm
             * error\nMust be: \n equals to Password", "Error",
             * JOptionPane.OK_OPTION);
             * labelPasswordLoginError.setStyle("-fx-text-fill:RED"); } else {
             *
             * createUser(); closeWindow(event);
             *
             * }
             *
             */
        } catch (FullNameException ex) {
            Logger.getLogger(Controller_Up.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Te preguntará si estas seguro si quieres cancelar el registro de usuario
     * Te llevará la ventana Principal y esta se cerrará
     *
     */
    @FXML
    private void handleButtonCancel(ActionEvent event) {

              Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        alert.setContentText("¿Estas Seguro?");
        Optional opc= alert.showAndWait();
        if (opc.isPresent()){
            if(opc.get()==ButtonType.OK){
                        stage.close();
            }
        }

    }

    @FXML
    private void start() {

        btnSignUp.setDisable(true);

        hideAlerts();

        limitPassword();
        limitLogin();
        limitFullName();
        limitGmail();
        limitPasswordConfirm();

    }

    private void hideAlerts() {
        labelLoginError.setStyle("-fx-text-fill:TRANSPARENT");
        labelFullNameError.setStyle("-fx-text-fill:TRANSPARENT");
        labelGmailError.setStyle("-fx-text-fill:TRANSPARENT");
        labelPasswordError.setStyle("-fx-text-fill:TRANSPARENT");
        labelPasswordLoginError.setStyle("-fx-text-fill:TRANSPARENT");
    }

    private void createUser() {

        Client cli = new Client();
        cli.setDatos(txtFieldLogin.getText(), txtFieldGmail.getText(), txtFieldFullName.getText(), txtFieldPassword.getText());
        JOptionPane.showMessageDialog(null, "User created successfully", "Done", JOptionPane.INFORMATION_MESSAGE);

    }

    private boolean checkLogin() {

        String cadena = txtFieldLogin.getText();
        int espacios = 0;
        if (cadena.length() > 2) {
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == ' ') {
                    espacios++;
                }
            }
        } else {
            espacios = -1;
        }
        if (espacios == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * private boolean checkLogin() {
     *
     * String cadena = txtFieldLogin.getText(); int espacios = 0; if
     * (cadena.length() > 2) { for (int i = 0; i < cadena.length(); i++) { if
     * (cadena.charAt(i) == ' ') { espacios++; } } } else { espacios = -1; } if
     * (espacios == 0) { return true; } else { return false; }
     *
     * }
     *
     */

    private void checkFullName() throws FullNameException {

        int letras = 0;

        String nombre = txtFieldFullName.getText();

        Pattern pattern = Pattern.compile("^[A-Za-z ]{0,50}$");

        Matcher macther = pattern.matcher(nombre);
        for (int i = 0; i < nombre.length(); i++) {

            if (nombre.charAt(i) != ' ') {

                letras++;
            }
            throw new FullNameException("");
        }

    }

    private boolean checkEmail() {

        String email = txtFieldGmail.getText();

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkPassword() {

        String passwd = txtFieldPassword.getText();

        if (passwd.length() < 3) {
            return false;
        } else {
            return true;
        }

    }

    private boolean checkConfirmPasword() {

        if (txtFieldConfrimPassword.getText().equals(txtFieldPassword.getText())) {
            return true;
        } else {
            return false;
        }

    }

    private void limitLogin() {
        txtFieldLogin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldLogin.getText().length() > 10) {
                    txtFieldLogin.setText(txtFieldLogin.getText().substring(0, 25));

                }

            }

        });
    }

    private void limitFullName() {
        txtFieldFullName.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldFullName.getText().length() > 10) {
                    txtFieldFullName.setText(txtFieldFullName.getText().substring(0, 50));

                }

            }

        });
    }

    private void limitGmail() {
        txtFieldGmail.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldGmail.getText().length() > 10) {
                    txtFieldGmail.setText(txtFieldGmail.getText().substring(0, 50));

                }

            }

        });
    }

    private void limitPassword() {

        txtFieldPassword.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldPassword.getText().length() > 10) {
                    txtFieldPassword.setText(txtFieldPassword.getText().substring(0, 10));

                }

            }

        });

    }

    private void limitPasswordConfirm() {

        txtFieldConfrimPassword.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldConfrimPassword.getText().length() > 10) {
                    txtFieldConfrimPassword.setText(txtFieldConfrimPassword.getText().substring(0, 10));

                }

            }

        });

    }

}

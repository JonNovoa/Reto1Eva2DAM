/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clases.AnswerEnumeration;
import clases.Client;
import clases.Message;
import exceptions.*;
import exceptions.FullNameException;
import exceptions.LoginException;
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
import model.ClientInterface;
import model.ImplementationClient;

/**
 *
 * @author Jon Novoa
 */
public class Controller_Up implements Initializable {

    private static final Logger logMsg = Logger.getLogger("");
    @FXML
    private Stage stage;
    @FXML
    private TextField txtFieldLogin;
    @FXML
    private TextField txtFieldFullName;
    @FXML
    private TextField txtFieldGmail;
    @FXML
    private PasswordField txtFieldPassword2;
    @FXML
    private PasswordField txtFieldConfrimPassword;
    @FXML
    private Button btnSignUp2;
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
        btnSignUp2.setOnAction(this::handleButtonSignUp);
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

    /**
     * Check the status of the fields, if any field is empty, the Sign button
     * will be disabled. Up button will be deactivated, when all the fields are
     * filled in, it will be activated. will be activated
     */
    public void keyReleasedProperty() {
        if (txtFieldLogin.getText().isEmpty() || txtFieldFullName.getText().isEmpty() || txtFieldGmail.getText().isEmpty() || txtFieldPassword2.getText().isEmpty() || txtFieldConfrimPassword.getText().isEmpty()
                || txtFieldLogin.getText().equals(" ") || txtFieldFullName.getText().equals(" ") || txtFieldGmail.getText().equals(" ") || txtFieldPassword2.getText().equals(" ") || txtFieldConfrimPassword.getText().equals(" ")) {
            btnSignUp2.setDisable(true);
        } else {
            btnSignUp2.setDisable(false);
        }
    }

    /**
     * When all fields are filled in the button will be enabled. The following
     * fields will be validated The login field: will have a maximum of 25
     * characters; it can have numbers, letters, special characters and no
     * spaces. have numbers, letters, special characters and may not have
     * spaces. No may not be already registered in the database. The full name
     * field: will have The gmail field: will have a maximum of 50 characters;
     * it can have only letters. The gmail field: will be checked for proper
     * formatting and a maximum of 50 characters. No may not be already
     * registered in the database The password and confirm password fields: you
     * will * have a maximum of 50 characters. confirm password: you will have a
     * maximum of 10 characters; it can have both * letters, numbers and special
     * characters. letters, numbers and special characters. The password and *
     * confirm password fields must be the same confirm password fields must be
     * the same If the Login, Full Name, Gmail, Password and Confirm Password
     * comply with the above, they will be validated and will be sent in a User
     * object that will be sent to the interface layer with the
     * registerUser(User user) method. If the credentials are not validated they
     * will be will be reported with a textLabel above the wrong field and an
     * exception will be raised depending on the wrong field. If the
     * registration is successful, the user will be notified by a textLabel If
     * the registration has been done correctly, the user will be notified with
     * a warning and which will take the user to the main window (SignIn), this
     * window will be closed. will close
     *
     */
    @FXML
    private void handleButtonSignUp(ActionEvent event) {
        hideAlerts();
        try {
            checkLogin();
            checkFullName();
            checkEmail();
            checkPassword();
            checkConfirmPasword();
            createUser();
        } catch (LoginException ex) {
            logMsg.log(Level.INFO, "login incorrecto ");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login error \n Must have: \n minimum 3 characters length \n no spaces", ButtonType.OK);
            alert.show();
            labelLoginError.setStyle("-fx-text-fill:RED");
        } catch (FullNameException ex) {
            logMsg.log(Level.INFO, "full name incorrecto ");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Full name error \n Must have: \n minimum 8 letters length", ButtonType.OK);
            alert.show();
            labelFullNameError.setStyle("-fx-text-fill:RED");
        } catch (EmailException ex) {
            logMsg.log(Level.INFO, "email incorrecto ");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email format incorrect \n Example: andrew@example.com", ButtonType.OK);
            alert.show();
            labelGmailError.setStyle("-fx-text-fill:RED");
        } catch (PasswordException ex) {
            logMsg.log(Level.INFO, "password incorrecto");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Password error \nMust have: \n minimum 4 characters length", ButtonType.OK);
            alert.show();
            labelPasswordError.setStyle("-fx-text-fill:RED");
        } catch (PasswordConfirmException ex) {
            logMsg.log(Level.INFO, "confirm password incorrecto");
            Alert alert = new Alert(Alert.AlertType.ERROR, "\"Password Confirm error\nMust be: \n equals to Password", ButtonType.OK);
            alert.show();
            labelPasswordLoginError.setStyle("-fx-text-fill:RED");
        }
    }

    /**
     * It will ask you if you are sure you want to cancel the user registration.
     * You will be taken to the Main window and it will close.
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
        Optional opc = alert.showAndWait();
        if (opc.isPresent()) {
            if (opc.get() == ButtonType.OK) {
                stage.close();
            }
        }
    }

    @FXML
    private void start() {
        btnSignUp2.setDisable(true);
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
        ClientInterface cliInter = new ImplementationClient();
        Message respuesta = new Message();
        Client cli = new Client();
        cli.setDatos(txtFieldLogin.getText(), txtFieldGmail.getText(), txtFieldFullName.getText(), txtFieldPassword2.getText());
        respuesta.setCliente(cli);
        respuesta = cliInter.registerClient(respuesta);
        if (respuesta.getRESPUESTA().equals(AnswerEnumeration.SINGUP)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("User created successfully");
            txtFieldLogin.setText("");
            txtFieldFullName.setText("");
            txtFieldGmail.setText("");
            txtFieldPassword2.setText("");
            txtFieldConfrimPassword.setText("");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al crear el usuario ", ButtonType.OK);
            alert.show();
        }
    }

    /**
     * Check that the login entered is not less than 2 characters and does not
     * contain spaces. have spaces
     *
     * @throws LoginException
     */
    private void checkLogin() throws LoginException {

        String cadena = txtFieldLogin.getText();
        int espacios = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                espacios++;
            }
        }
        if (cadena.length() < 3 || espacios != 0) {
            throw new LoginException();
        }
    }

    /**
     * Check that the full name has only letters and is a minimum of 8 letters.
     *
     * @throws FullNameException
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
        }
        if (letras < 8 || macther.find() == false) {
            throw new FullNameException();
        }
    }

    /**
     * Check that the format of the email entered is correct.
     *
     * @throws EmailException
     */
    private void checkEmail() throws EmailException {
        String email = txtFieldGmail.getText();
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == false) {
            throw new EmailException();
        }
    }

    /**
     * Check that the length of the password is at least 4 characters long. and
     * has no spaces
     *
     * @throws PasswordException
     */
    private void checkPassword() throws PasswordException {
        String passwd = txtFieldPassword2.getText();
        boolean error = true;
        for (int i = 0; i < passwd.length(); i++) {
            if (passwd.charAt(i) == ' ') {
                error = false;
            }
        }
        if (error == false || passwd.length() < 4) {
            throw new PasswordException();
        }
    }

    /**
     * Check that the password confirmation is the same as the password.
     *
     * @throws PasswordConfirmException
     */
    private void checkConfirmPasword() throws PasswordConfirmException {
        if (!txtFieldConfrimPassword.getText().equals(txtFieldPassword2.getText())) {
            throw new PasswordConfirmException();
        }
    }

    /**
     * Limits the login so that the user can only enter a maximum of 25
     * characters characters
     */
    private void limitLogin() {
        txtFieldLogin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldLogin.getText().length() > 25) {
                    txtFieldLogin.setText(txtFieldLogin.getText().substring(0, 25));
                }
            }
        });
    }

    /**
     * Limit the full name so that the user can only enter a maximum of 50
     * characters. of 50 characters
     */
    private void limitFullName() {
        txtFieldFullName.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldFullName.getText().length() > 50) {
                    txtFieldFullName.setText(txtFieldFullName.getText().substring(0, 50));
                }
            }
        });
    }

    /**
     * Limit gmail so that the user can only enter a maximum of 50 characters
     */
    private void limitGmail() {
        txtFieldGmail.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldGmail.getText().length() > 50) {
                    txtFieldGmail.setText(txtFieldGmail.getText().substring(0, 50));
                }
            }
        });
    }

    /*
     * Limits the password so that the user can only enter a maximum of 10
     * characters
     */
    private void limitPassword() {
        txtFieldPassword2.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (txtFieldPassword2.getText().length() > 10) {
                    txtFieldPassword2.setText(txtFieldPassword2.getText().substring(0, 10));
                }
            }
        });
    }

    /**
     * Limit the password confirm so that the user can only enter a maximum of
     * 10 characters. maximum of 10 characters
     */
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

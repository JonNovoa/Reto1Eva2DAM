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
import javax.swing.JOptionPane;
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
    private Label label;

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
     * Comprueba el estado de los campos , si hay alguno vacio el boton de Sign
     * Up estara desactivado, en el momento que se rellenen todo los campos se
     * activara
     */
    public void keyReleasedProperty() {

        if (txtFieldLogin.getText().isEmpty() || txtFieldFullName.getText().isEmpty() || txtFieldGmail.getText().isEmpty() || txtFieldPassword2.getText().isEmpty() || txtFieldConfrimPassword.getText().isEmpty() ||
            txtFieldLogin.getText().equals(" ") || txtFieldFullName.getText().equals(" ") || txtFieldGmail.getText().equals(" ") || txtFieldPassword2.getText().equals(" ") || txtFieldConfrimPassword.getText().equals(" ")) {
            btnSignUp2.setDisable(true);
           

        } else {
            btnSignUp2.setDisable(false);
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
           // JOptionPane.showMessageDialog(null, "Login error \n Must have: \n minimum 3 characters length \n no spaces", "Error", JOptionPane.OK_OPTION);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login error \n Must have: \n minimum 3 characters length \n no spaces", ButtonType.OK);
             alert.show();
           labelLoginError.setStyle("-fx-text-fill:RED");
        } catch (FullNameException ex) {
            logMsg.log(Level.INFO, "full name incorrecto ");
            //JOptionPane.showMessageDialog(null, "Full name error \n Must have: \n minimum 8 letters length", "Error", JOptionPane.OK_OPTION);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Full name error \n Must have: \n minimum 8 letters length", ButtonType.OK);
             alert.show();
            labelFullNameError.setStyle("-fx-text-fill:RED");
        } catch (EmailException ex) {
            logMsg.log(Level.INFO, "email incorrecto ");
            //JOptionPane.showMessageDialog(null, "Email format incorrect \n Example: andrew@example.com", "Error", JOptionPane.OK_OPTION);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email format incorrect \n Example: andrew@example.com", ButtonType.OK);
             alert.show();
            labelGmailError.setStyle("-fx-text-fill:RED");
        } catch (PasswordException ex) {
            logMsg.log(Level.INFO, "password incorrecto");
           // JOptionPane.showMessageDialog(null, "Password error \nMust have: \n minimum 4 characters length", "Error", JOptionPane.OK_OPTION);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Password error \nMust have: \n minimum 4 characters length", ButtonType.OK);
             alert.show();
           labelPasswordError.setStyle("-fx-text-fill:RED");
        } catch (PasswordConfirmException ex) {
            logMsg.log(Level.INFO, "confirm password incorrecto");           
            //JOptionPane.showMessageDialog(null, "\"Password Confirm error\nMust be: \n equals to Password", "Error", JOptionPane.OK_OPTION);
            Alert alert = new Alert(Alert.AlertType.ERROR, "\"Password Confirm error\nMust be: \n equals to Password", ButtonType.OK);
             alert.show();
            labelPasswordLoginError.setStyle("-fx-text-fill:RED");
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
        Message respuesta=new Message();
        Client cli = new Client();
        cli.setDatos(txtFieldLogin.getText(), txtFieldGmail.getText(), txtFieldFullName.getText(), txtFieldPassword2.getText());
        respuesta.setCliente(cli);
        respuesta=cliInter.registerClient(respuesta);
    if( respuesta.getRESPUESTA().equals(AnswerEnumeration.SINGUP)){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Usuario creado correctamente");
        txtFieldLogin.setText("");
        txtFieldFullName.setText("");
        txtFieldGmail.setText("");
        txtFieldPassword2.setText("");
        txtFieldConfrimPassword.setText("");
        alert.showAndWait();
        
        }else {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Error al crear el usuario ", ButtonType.OK);
        alert.show();
    }
    
    }

    /**
     * Comprueba que el login que se introduza no sea menor a 2 caracteres y no
     * tenga espacios
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
     * Comprueba que el full name tenga solo letras y sean un minimo de 8
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
     * Comprueba que el formato del email introducido sea el correcto
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
     * Comprueba que la longuitud de la password sea al menos de 4 caracteres
     * y no tenga espacios
     *
     * @throws PasswordException
     */
    private void checkPassword() throws PasswordException {

        String passwd = txtFieldPassword2.getText();
        boolean error=true;
        
        
            
          for (int i =0; i < passwd.length()  ;i++){
             if (passwd.charAt(i) == ' ') {

                error = false;
            }
           }
         
        
        if(error ==false ||  passwd.length()<4){
           throw new PasswordException();  
        }
        

    }

    /**
     * Comprueba que el la confirmacion de la password sea igual que la password
     *
     * @throws PasswordConfirmException
     */
    private void checkConfirmPasword() throws PasswordConfirmException {

        if (!txtFieldConfrimPassword.getText().equals(txtFieldPassword2.getText())) {
            throw new PasswordConfirmException();
        }

    }

    /**
     * Limita el login para que el usuario solo pueda introducir un maximo de 25
     * caracteres
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
     * Limita el full name para que el usuario solo pueda introducir un maximo
     * de 50 caracteres
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
     * Limita el gmail para que el usuario solo pueda introducir un maximo de 50
     * caracteres
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

    /**
     * Limita el password para que el usuario solo pueda introducir un maximo de
     * 10 caracteres
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
     * Limita el password confirm para que el usuario solo pueda introducir un
     * maximo de 10 caracteres
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

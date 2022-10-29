/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clases.Client;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author somor
 */
public class Controller_Log implements Initializable {

    Client user;
    @FXML
    private Stage stage;
    @FXML
    private Button btnSignOut;
    @FXML
    private Label labelCongrat;
    @FXML
    private AnchorPane raiz;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // labelCongrat.setText("Hey quepassss!!!!!!!!!!!!!!");
        btnSignOut.setOnAction(this::hadleButtonSignOut);

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void recuperarUser() {
        System.out.println(this.user.getLogin() + " hey ");
        labelCongrat.setText(String.format("hey", user.getLogin()));
    }

    @FXML
    private void hadleButtonSignOut(ActionEvent event) {
        //Creamos un Nodo para poder salir de la ventana Sign out
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

    void setUsuario(Client user) {
        this.user = user;
    }

    void initStage(Parent root) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Log In");
        stage1.setResizable(false);
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.showAndWait();
    }
}

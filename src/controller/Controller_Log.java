/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clases.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 *
 * @author somor
 */
public class Controller_Log implements Initializable {

    Client user;
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
        stage.close();
    }

    void setUsuario(Client user) {
        this.user = user;
    }
}

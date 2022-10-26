/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author somor
 */
public class Controller_Log implements Initializable {

    @FXML
    private Button btnSignOut;
     @FXML
    private Label labelCongrat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       labelCongrat.setText("Hey quepassss!!!!!!!!!!!!!!");
        btnSignOut.setOnAction(this::hadleButtonSignOut);

    }

    @FXML

    private void hadleButtonSignOut(ActionEvent event) {
             Node source = (Node) event.getSource();
           Stage stage = (Stage) source.getScene().getWindow();
           stage.close();
    }
}

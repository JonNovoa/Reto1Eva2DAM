/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.ButtonMatchers.isDefaultButton;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 *
 * @author Gonzalo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ModificacionDinTestSignInGonzalo extends ApplicationTest {
    
    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Main.class);
    }
    
    @Test

    //Comprueba que se abre la ventana
    public void test01_AbrirVentana() {

        verifyThat("#PaneIn", isVisible());
    }

    @Test

    //Comprueba el estado de la ventana al iniciarse
    public void test02_EstadoVentana() {
        verifyThat("#txtFieldUser", hasText(""));
        verifyThat("#txtFieldPassword", hasText(""));
        verifyThat("#btnSignIn", isEnabled());
        verifyThat("#btnSignUp", isEnabled());
    }

    @Test

    //Comprueba que se abre la ventana Sign Up al clicar en el boton Sign Up
    public void test03_BotonSignUpBien() {
        clickOn("#btnSignUp");
        verifyThat("#PaneUp", isVisible());
    }

    @Test

    //Comprueba que salta un alert al hacer un Sign In con los campos vacios
    public void test04_SignInCamposVacios() {
        clickOn("#btnCancel");
        clickOn(isDefaultButton());
        clickOn("#btnSignIn");
        verifyThat("Some empty field", isVisible());
        clickOn(isDefaultButton());

    }

    @Test
    
    //Comprobar si salta el alert solo con contraseña vacia
    public void test05_SigInContraseñaVacia() {
        clickOn("#txtFieldUser");
        write("Gonzalo");        
        clickOn("#btnSignIn");
        verifyThat("Some empty field", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    
    //Comprobar si salta el alert solo con usuario vacio
    public void test06_SigInUsuarioVacio() {
        clickOn("#txtFieldUser");
        eraseText(7);        
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        verifyThat("Some empty field", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    
    //Comprueba que si salta el alert con ambos campos mal
    public void test07_UsuarioContraseñaMal() {
        clickOn("#txtFieldUser"); 
        write("Gonzal");
        clickOn("#txtFieldPassword");
        eraseText(9);  
        write("abcd*123");
        clickOn("#btnSignIn");
        verifyThat("User or password wrong ", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    
    //Comprueba que si salta el alert con el usuario bien y contraseña mal
    public void test08_ContraseñaMal() {
        clickOn("#txtFieldUser");
        eraseText(7);
        write("Gonzalo");
        clickOn("#btnSignIn");
        verifyThat("User or password wrong ", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    
    //Comprueba que si salta el alert con el usuario mal y contraseña bien
    public void test09_UsuarioMal() {
        clickOn("#txtFieldUser");
        eraseText(1);  
        clickOn("#txtFieldPassword");     
        write("4");
        clickOn("#btnSignIn");
        verifyThat("User or password wrong ", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    
    //Comprueba que se realiza el Sign In correctamente
    public void test10_SignInBien() {
        clickOn("#txtFieldUser");
        write("o");
        clickOn("#btnSignIn");
        verifyThat("#PaneOut", isVisible());
    }

}

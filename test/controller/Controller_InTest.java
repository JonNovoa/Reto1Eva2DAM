/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import java.awt.TextField;
import java.util.concurrent.TimeoutException;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isNull;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 *
 * @author somor
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class Controller_InTest extends ApplicationTest {
    
    private TextField txtFieldUser;
    private TextField txtFieldPassword;

    /**
    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Main.class);
   }
    **/
      @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
    }
    /**
     * Comprueba que los campos de Login y contraseña esten vacios al iniciarse
     * la aplicacion y que los botones Sign Up y Sign In esten habitados
     */
    @Test
    public void test1_InitialState() {
        
         verifyThat("#txtFieldUser", hasText(""));
         verifyThat("#txtFieldPassword", hasText(""));
         verifyThat("#btnSignIn", isEnabled());
       verifyThat("#btnSignUp", isEnabled());
    }
    
    /**
    * Comprueba que al pulsar el boton Sign Up no lleve a la ventana para 
    * registrarse
    */
   
     @Test
    public void test2_GTSignUp(){
        
        clickOn("#btnSignUp");
        verifyThat("#PaneUp", isVisible());
       
    }
    
    
}

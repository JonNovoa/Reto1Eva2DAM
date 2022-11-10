/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import java.awt.TextField;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.ButtonMatchers.isDefaultButton;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 *
 * @author somor
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class Controller_InTest extends ApplicationTest {
    
    private TextField txtFieldUser;
    private TextField txtFieldPassword;

      @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
    }
    /**
     * Check that the Login and Password fields are empty at startup and that the Sign Up and Sign In buttons are empty
     * and that the Sign Up and Sign In buttons are Enabled.
     */
    @Test
    public void test1_InitialState() {
        
         verifyThat("#txtFieldUser", hasText(""));
         verifyThat("#txtFieldPassword", hasText(""));
         verifyThat("#btnSignIn", isEnabled());
       verifyThat("#btnSignUp", isEnabled());
    }
    
    /**
    * Check that clicking the Sign Up button does not take you to the window to 
    * register
    */
   
     @Test
    public void test2_GTSignUp(){
        
        clickOn("#btnSignUp");
        verifyThat("#PaneUp", isVisible());
       
    }
    /**
     * Checks that the Login does not exist and the alert pops up.
     */
    @Test
    public void test3_WrongLogin(){
        clickOn("#txtFieldUser");
        write("noexiste");
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }
    
    /**
     * Checks that the Password does not match with the Login and the alert pops up.
     */
    @Test
    public void test4_WrongPassword(){
        clickOn("#txtFieldUser");
        write("Gonzalo");
        clickOn("#txtFieldPassword");
        write("abcd*12345");
        clickOn("#btnSignIn");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }
    
    /**
     * Checks that the fields are empty and the alert pops up.
     */
    @Test
    public void test5_EmptyFields(){
        clickOn("#btnSignIn");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }
    /**
     * Check that the Log in is successful and the Sign Out window opens.
     */
    @Test
    public void test6_GTSignOut(){
        clickOn("#txtFieldUser");
        write("Gonzalo");
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        verifyThat("#PaneOut", isVisible());
    }
}

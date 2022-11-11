/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author somor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Controller_LogTest extends ApplicationTest{
    
    @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
    }
    /**
     * Logs in And checks that the sign out button is Enabled.
     */
     @Test
    public void test1_InitialState() {
        clickOn("#txtFieldUser");
        write("Gonzalo");
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        verifyThat("#btnSignOut", isEnabled());
       
      
    }
    
    /**
     * Check that pressing the Sign Out button an alert pops up and 
     * the window closes.
     */
     @Test
    public void test2_GTSignIn() {
        clickOn("#txtFieldUser");
        write("Gonzalo");
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        clickOn("#btnSignOut");
        verifyThat(".alert", isVisible());
        clickOn("Aceptar");
        verifyThat("#PaneIn", isVisible());
      
    }
    
    /**
     * Check that pressing the Sign Out button an alert pops up
     * and the window does not close.
     */
    @Test
    public void test3_Stay() {
        clickOn("#txtFieldUser");
        write("Gonzalo");
        clickOn("#txtFieldPassword");
        write("abcd*1234");
        clickOn("#btnSignIn");
        clickOn("#btnSignOut");
        verifyThat(".alert", isVisible());
        clickOn("Cancelar");
        verifyThat("#PaneOut", isVisible());
      
    }
    
}

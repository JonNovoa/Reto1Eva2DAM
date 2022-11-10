/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

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
    
     @Test
    public void test1_InitialState() {
        
        
      
    }
     @Test
    public void test2_GTSignIn() {
        
      
    }
    
}

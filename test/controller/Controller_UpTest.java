/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
import application.Main;
import java.awt.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isNull;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.ButtonMatchers.isDefaultButton;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

**/
import application.Main;

import javafx.scene.control.Alert;

import javafx.scene.control.TextField;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import javafx.stage.Stage;

import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.ButtonMatchers.isDefaultButton;

import static org.testfx.matcher.control.TextInputControlMatchers.hasText;


/**
 *
 * @author somor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Controller_UpTest extends ApplicationTest {
    
   // private JOptionPane j;
    private Alert alert;
    private TextField FieldLogin;
    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
    //   FieldLogin   = (TextField) lookup("#txtFieldLogin");
    }
    /**
     * Check that the fields are empty and that the Sign Up button is disabled and the Cancel button is enabled. 
     * disabled and the Cancel button is enabled.
     */
    

   /** @Test
    public void test0_Initialize() {

        clickOn("#btnSignUp");
        verifyThat("#txtFieldLogin", hasText(""));
        verifyThat("#txtFieldFullName", hasText(""));
        verifyThat("#txtFieldGmail", hasText(""));
        verifyThat("#txtFieldPassword2", hasText(""));
        verifyThat("#txtFieldConfrimPassword", hasText(""));
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());
      

    }

    /**
     * Test that verifies that the Sign Up button is enabled only when all fields are filled in.
     * fields are filled in
     **/
     
    @Test
    public void test1_SignUpIsEnabled() {

        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("pepe3");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");

        verifyThat("#btnCancel", isEnabled());

        verifyThat("#btnSignUp2", isEnabled());

    }
    /**
     * Check that the error alert is displayed when entering less than 
     * 3 characters
     */
    
     @Test
    public void test2_LoginError1() {
        
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Login error \n Must have: \n minimum 3 characters length \n no spaces", isVisible());    
       clickOn(isDefaultButton());
       
    }
      /**
     *  Check that the error alert is displayed when you enter  
     *  a login with spaces
     */
    
     @Test
    public void test3_LoginError2() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("p e");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Login error \n Must have: \n minimum 3 characters length \n no spaces", isVisible());    
       clickOn(isDefaultButton());
    }
    
    
    /**
     * Check that the error alert is displayed when entering a full name with 
     * less than 8 letters
     */
    
 @Test
    public void test4_FullNameError1() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Full name error \n Must have: \n minimum 8 letters length", isVisible());    
       clickOn(isDefaultButton());
    }
   /**
    * Check that the error alert is displayed when entering a full name with a full name with
    * containing characters other than letters
    */
    
     @Test
    public void test5_FullNameError2() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe12345678");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Full name error \n Must have: \n minimum 8 letters length", isVisible());    
       clickOn(isDefaultButton());
    }
  /**
   * Check that the error alert is displayed if an email is entered without the proper * formatting (without @) 
   * proper formatting (without @)
   */
    
     @Test
    public void test6_GmailError1() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepegmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Email format incorrect \n Example: andrew@example.com", isVisible());    
       clickOn(isDefaultButton());
    }
    
     /**
   * Check that the error alert is displayed if an email is entered without the proper format (without . 
   * proper formatting (without .)
   */
    
    
      @Test
    public void test7_GmailError2() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmailcom");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat("Email format incorrect \n Example: andrew@example.com", isVisible());    
       clickOn(isDefaultButton());
    }    
    
    /**
     * Check that the error alert is displayed if a password is entered.
     * with less than four characters in length
     */

     @Test
    public void test8_PasswordError1() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abc");
        clickOn("#txtFieldConfrimPassword");
         write("abc");
        clickOn("#btnSignUp2");  
        verifyThat(".alert", isVisible());    
       clickOn(isDefaultButton());
    }
   /**
    * Check that the error alert is displayed if a password with * spaces is entered. 
    * spaces
    */
    
    
     @Test
    public void test9_PasswordError2() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("ab 4c");
        clickOn("#txtFieldConfrimPassword");
         write("abc");
        clickOn("#btnSignUp2");  
        verifyThat("Password error \nMust have: \n minimum 4 characters length", isVisible());    
       clickOn(isDefaultButton());
    }
    
    /**
     * Check that the error alert is displayed if it is entered in the confrim
     * password a password different from the passwords
     */
    /**
    
    @Test
    public void test10_PasswordConfirmError1() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd");
        clickOn("#txtFieldConfrimPassword");
         write("acd");
        clickOn("#btnSignUp2");  
        verifyThat("\"Password Confirm error\nMust be: \n equals to Password", isVisible());    
       clickOn(isDefaultButton());
    }
    
    /**
     * Check that a message is displayed indicating that the user has successfully 
     * registered (check that he/she is not registered in the database). 
     */
    
    @Test
    public void test11_UserCreated1() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe1");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe123@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd");
        clickOn("#txtFieldConfrimPassword");
         write("abcd");
        clickOn("#btnSignUp2");
        verifyThat(".alert", isVisible());
       clickOn(isDefaultButton());
    }
  
    /**
     * check that if a space is entered at the beginning, the sign up button 
     * is disabled.
     */
    @Test
    public void test12_EmptyEspaces() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write(" ");
        clickOn("#txtFieldFullName");
        write(" ");
         clickOn("#txtFieldGmail");
        write(" ");
        clickOn("#txtFieldPassword2");
       write(" ");
        clickOn("#txtFieldConfrimPassword");
         write(" ");
        clickOn("#btnSignUp2");  
        verifyThat("#btnSignUp2", isDisabled());  
    }
    
    
    /**
     * check if pressing the cancel button and then clicking on accept shows 
     * the sign in window.
     */
     @Test
    public void test13_GTSignIn() {
        clickOn("#btnSignUp");
        clickOn("#btnCancel");  
         clickOn("Cancelar");
        verifyThat("#PaneUp", isVisible());  
    }
    
    /**
     * Check that the Gmail is repeated and the alert pops up.
     * (check that the gmail is in the DB)
     */    
    @Test
    public void test14_GmailExists() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe1234");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat(".alert", isVisible());    
       clickOn(isDefaultButton());
    }
    /**
     * Check that the Login is repeated and the alert pops up.
     * (check that the login is in the DB)
     */
     @Test
    public void test15_LoginExists() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("pepe");
        clickOn("#txtFieldFullName");
        write("pepe perez garcia");
         clickOn("#txtFieldGmail");
        write("pepe1234@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat(".alert", isVisible());    
       clickOn(isDefaultButton());
    }
    /**
     * check if the sign up window is still displayed by clicking on the cancel button 
     *	and then clicking on cancel
     */
     @Test
    public void test16_Stay() {
        clickOn("#btnSignUp");
        clickOn("#btnCancel");  
         clickOn("Aceptar");
        verifyThat("#PaneUp", isVisible());  
    }
    
}

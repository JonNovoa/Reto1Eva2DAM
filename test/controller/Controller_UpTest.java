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
import org.testfx.service.query.NodeQuery;


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
     * Comprueba que los campos esten vacios y que el boton Sign Up esta 
     * desabilitado y el boton Cancel habilitado
     */
    

   /** @Test
    public void test0_Initialize() {

        clickOn("#btnSignUp");
        verifyThat("#txtFieldLogin", hasText(""));
        verifyThat("#txtFieldFullName", hasText(""));
        verifyThat("#txtFieldGmail", hasText(""));
        verifyThat("#txtFieldPassword", hasText(""));
        verifyThat("#txtFieldConfrimPassword", hasText(""));
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());
      

    }

    /**
     * Test que comprueba que el boton Sign Up se habilita solo cuando todos los
     * campos esten rellenos
     **/
     /**
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
     * Comprueba que salga la alerta de error al introducir menos de 
     * 3 caracteres
     */
    /**
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
        //verifyThat(".alert", NodeMatchers.isVisible()); 
       // write("abcd*1234");
  // verifyThat("#labelLoginError", );
        // clickOn("#txtFieldLogin");
       // txtFieldLogin = lookup("#txtFieldLogin").query();
       //  eraseText(txtFieldLogin.getText().length());
       // write("abcd*1234");
    }
      /**
     * Comprueba que salga la alerta de error al introducir  
     * un login con espacios
     */
    /**
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
     * Comprueba que salga la alerta de error al introducir un full name con 
     * menos de 8 letras
     */
    /**
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
    * Comprueba que salga la alerta de error al introducir un full name con
    * que contenga caracteres diferentes a letras
    */
    /**
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
   * Comprueba que salga la alerta de error si se introduce un email sin el 
   * formato adecuado (sin @)
   */
    /**
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
   * Comprueba que salga la alerta de error si se introduce un email sin el 
   * formato adecuado (sin .)
   */
    /**
    
      @Test
    public void test6_GmailError2() {
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
     * Comprueba que salga la alerta de error si se introduce una contraseña
     * con menos de cuatro caracteres de longuitud
     */
/**
     @Test
    public void test6_PasswordError1() {
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
        verifyThat("Password error \nMust have: \n minimum 4 characters length", isVisible());    
       clickOn(isDefaultButton());
    }
   /**
    * Comprueba que salga la alerta de error si se introduce una contraseña con 
    * espacios
    */
    /**
    
     @Test
    public void test7_PasswordError2() {
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
     * Comprueba que salga la alerta de error si se introduce en el confrim
     * password una contraseña diferente a las password
     */
    /**
    
    @Test
    public void test8_PasswordConfirmError1() {
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
     * Comprueba que salga la un mensaje indicando que el usuario se a 
     * registrado correctamente(comprobar que no este registrado en la base de datos)
     * 
     */
    /**
    @Test
    public void test9_UserCreated1() {
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
        verifyThat("User created successfully", isVisible());    
       clickOn(isDefaultButton());
    }
    */
      @Test
    public void test9_UserCreatedExistingMail() {
         clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
         write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Vargas");
         clickOn("#txtFieldGmail");
        write("josue@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
         write("abcd*1234");
        clickOn("#btnSignUp2");  
        verifyThat(".alert", isVisible());  
        clickOn(isDefaultButton());
    }
  /**
    @Test
    public void test10_EmptyEspaces() {
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
    
    
    
     @Test
    public void test11_GTSignIn() {
        clickOn("#btnSignUp");
        clickOn("#btnCancel");  
         clickOn("Cancelar");
        verifyThat("#PaneUp", isVisible());  
    }
    
    
     @Test
    public void test16_Stay() {
        clickOn("#btnSignUp");
        clickOn("#btnCancel");  
         clickOn("Aceptar");
        verifyThat("#PaneUp", isVisible());  
    }
*/    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prueba2din;

import application.Main;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.ButtonMatchers.isDefaultButton;

/**
 *
 * @author josue
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
    }

    @Test
    public void test1_SignUpIsEnabled() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue987");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldFullName");
        write("Josue Omar Vargas Flores");
        verifyThat("#btnSignUp2", isDisabled());
        verifyThat("#btnCancel", isEnabled());

        clickOn("#txtFieldGmail");
        write("josue9876@gmail.com");
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

    @Test
    public void test2_LoginError1() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("jo");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue456@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Login error \n Must have: \n minimum 3 characters length \n no spaces", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test3_LoginError2() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("j o");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Login error \n Must have: \n minimum 3 characters length \n no spaces", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test4_FullNameError1() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue987");
        clickOn("#txtFieldFullName");
        write("josue");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Full name error \n Must have: \n minimum 8 letters length", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test5_FullNameError2() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("josue987");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Full name error \n Must have: \n minimum 8 letters length", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void Test6_CheckMail() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Email format incorrect \n Example: andrew@example.com", isVisible());
        clickOn(isDefaultButton());

    }

    @Test
    public void Test7_CheckMail() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987@gmailcom");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Email format incorrect \n Example: andrew@example.com", isVisible());
        clickOn(isDefaultButton());

    }

    @Test
    public void Test8_CheckPassword() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd *1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("Password error \nMust have: \n minimum 4 characters length", isVisible());
        clickOn(isDefaultButton());

    }

    @Test
    public void Test9_CheckPassword() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abc");
        clickOn("#txtFieldConfrimPassword");
        write("abc");
        clickOn("#btnSignUp2");
        verifyThat("Password error \nMust have: \n minimum 4 characters length", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void Test10_CheckConfirmPassword() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue987@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*12345");
        clickOn("#btnSignUp2");
        verifyThat("Password Confirm error\nMust be: \n equals to Password", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test11_UserExist() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue123");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue123@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test12_MailExist() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue987");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue.vargas@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }

    @Test
    public void test13_BotonCancel() {
        clickOn("#btnSignUp");
        clickOn("#btnCancel");
        clickOn("Cancelar");
        verifyThat("#PaneUp", isVisible());
    }
    
    @Test
    public void test15_Vacio() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue987");
        clickOn("#txtFieldFullName");
        write("");
        clickOn("#txtFieldGmail");
        write("josue.vargas@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat("#btnSignUp2", isDisabled());
    }
    @Test
    public void test16_CreateUser() {
        clickOn("#btnSignUp");
        clickOn("#txtFieldLogin");
        write("josue9871");
        clickOn("#txtFieldFullName");
        write("Josue Flores");
        clickOn("#txtFieldGmail");
        write("josue.vargas1231@gmail.com");
        clickOn("#txtFieldPassword2");
        write("abcd*1234");
        clickOn("#txtFieldConfrimPassword");
        write("abcd*1234");
        clickOn("#btnSignUp2");
        verifyThat(".alert", isVisible());
        clickOn(isDefaultButton());
    }

}

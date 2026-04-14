package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LoginPage2;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest2 {

        private WebDriver driver;
        private LoginPage2 loginPage2;

        @BeforeEach
        void setUp() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.get("https://www.saucedemo.com/");

                loginPage2 = new LoginPage2(driver);
        }

        @AfterEach
        void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        @Test
        void loginCorrecto() throws InterruptedException {
                // introduce un usuario válido
                loginPage2.ingresarUsuario("standard_user");
                Thread.sleep(2000);

                // introduce una contraseña válida
                loginPage2.ingresarPassword("secret_sauce");
                Thread.sleep(2000);

                // pulsa el botón de login
                loginPage2.clickLogin();
                Thread.sleep(2000);

                // comprueba que la URL contiene la palabra "inventory"
                String urlActual = driver.getCurrentUrl();
                assertTrue(urlActual.contains("inventory"), "La URL no es la esperada tras el login");
        }

        @Test
        void loginIncorrecto() throws InterruptedException {
                //Contraseña incorrecta
                loginPage2.ingresarUsuario("standard_user");
                Thread.sleep(2000);

                loginPage2.ingresarPassword("password_incorrecto");
                Thread.sleep(2000);

                //Click del boton
                loginPage2.clickLogin();
                Thread.sleep(2000);

                // Mensaje de error
                String mensaje = loginPage2.obtenerMensajeError();
                assertTrue(mensaje.contains("Epic sadface"), "El mensaje de error no es el esperado");
        }

        @Test
        void loginCorrecto2() throws InterruptedException {

                loginPage2.login("standard_user", "secret_sauce");

                Thread.sleep(2000);

                String urlActual = driver.getCurrentUrl();
                assertTrue(urlActual.contains("inventory"), "La URL no es la esperada tras el login");
        }

        @Test
        void loginIncorrecto2() throws InterruptedException {

                loginPage2.login("standard_user", "password_incorrecto");

                Thread.sleep(2000);

                String mensaje = loginPage2.obtenerMensajeError();
                assertTrue(mensaje.contains("Epic sadface"), "El mensaje de error no es el esperado");
        }





}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 {
    private WebDriver driver;

    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage2(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarUsuario(String user) {
        driver.findElement(userField).sendKeys(user);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(passField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String obtenerMensajeError() {
        return driver.findElement(errorMsg).getText();
    }

    public void login(String user, String pass) throws InterruptedException {
        ingresarUsuario(user);
        Thread.sleep(1000); // Pausa opcional para observar

        ingresarPassword(pass);
        Thread.sleep(1000);

        clickLogin();
    }

}

package CasoDeTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DockerLogin {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;
    private WebElement user, pass,continuarUser,continuarPass;

    public DockerLogin(WebDriver driver){
        this.driver = driver;
        time = Duration.ofMillis(4000);
        wait = new WebDriverWait(this.driver,time);
    }

    public void login(String username, String password){
        user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c3515fa31")));
        user.sendKeys(username);

        continuarUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cec7de2e9")));
        continuarUser.click();

        pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c7690d6ae")));
        pass.sendKeys(password);

        continuarPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_button-login-password")));
        continuarPass.click();
    }

    public void loginIncorrecto(String username, String password){
        user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c3515fa31")));
        user.sendKeys(username);

        continuarUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cec7de2e9")));
        continuarUser.click();

        pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c7690d6ae")));
        pass.sendKeys(password);

        continuarPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_button-login-password")));
        continuarPass.click();

        boolean isLoggedIn = driver.findElements(By.id("profileLink")).size() > 0;
        Assert.assertFalse(isLoggedIn,"El usuario no deberia haber iniciado sesion");

    }


}

package CasoDeTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DockerCookies {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;

    public DockerCookies(WebDriver driver){
        this.driver = driver;
        time = Duration.ofMillis(4000);
        wait = new WebDriverWait(this.driver,time);
    }

    public void cerrarCookies(){
        WebElement cerrarCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("banner-close-button")));
        cerrarCookie.click();
    }
}

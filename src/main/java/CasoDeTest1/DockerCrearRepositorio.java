package CasoDeTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DockerCrearRepositorio {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;
    private WebElement nameRepository, description;

    public DockerCrearRepositorio(WebDriver driver){
        this.driver = driver;
        time = Duration.ofMillis(4000);
        wait = new WebDriverWait(this.driver,time);
    }

    public void crearRepositorio(String nameRepository,String description){
        WebElement inputRepositoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/div/input")));
        inputRepositoryName.sendKeys(nameRepository);

        WebElement inputDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div[3]/div/div/div/textarea[1]")));
        inputDescription.sendKeys(description);

        WebElement btnCreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/form/div[2]/div/button")));
        btnCreate.click();
    }


}

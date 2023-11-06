package CasoDeTest1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Docker {
    private WebDriver driver;
    private DockerLogin dockerLogin;
    private DockerCookies dockerCookies;

    private DockerCrearRepositorio dockerCrearRepositorio;

    @BeforeClass
    public void initPageFactory(){
        // Creamos una instancia del driver
        driver = new ChromeDriver();
        dockerLogin = PageFactory.initElements(driver,DockerLogin.class);
        dockerCookies = PageFactory.initElements(driver,DockerCookies.class);
        dockerCrearRepositorio = PageFactory.initElements(driver,DockerCrearRepositorio.class);
    }

    @Test (priority = 1)
    public void loadPage(){
        driver.navigate().to("https://www.docker.com/");
        String titulo = driver.getTitle();
        System.out.println("titulo " + titulo);
        Assert.assertEquals(titulo,"Docker: Accelerated Container Application Development");
    }

    @Test(priority = 2)
    public void login() {
        // Inicializamos el objeto WebDriverWait después de crear el driver
        Duration time=Duration.ofMillis(4000);
        WebDriverWait wait = new WebDriverWait(driver, time);
        //Voy a la pestaña de iniciar sesion
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
        element.click();
        //inicio sesion
        dockerLogin.login("email","password");
        //Sacamos las cookies molestas
        dockerCookies.cerrarCookies();
    }

    @Test(priority = 3)
    public void crearRepositorio(){
        Duration time=Duration.ofMillis(4000);
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement btnCreateRepository = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[3]/span[1]/a/div")));
        btnCreateRepository.click();
        dockerCrearRepositorio.crearRepositorio("repositoryname3","descripcionprueba");
    }
    @Test(priority = 4)
    public void logout(){
        Duration time=Duration.ofMillis(4000);
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement contSingout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/header/div/div/nav/div[2]/button")));
        contSingout.click();
        WebElement singOut= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/ul/li")));
        singOut.click();
    }
    @Test(priority = 5)
    public void loginIncorrecto(){
        Duration time=Duration.ofMillis(4000);
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement logInLastLogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log_in")));
        logInLastLogOut.click();
        dockerLogin.loginIncorrecto("valentincaminosmartinez@hotmail.com","asd");
    }

    public void closeDriver(){
        if(driver!=null){
            driver.close();
            System.out.println("Se finalizo el test correctamente");
        }
    }
}

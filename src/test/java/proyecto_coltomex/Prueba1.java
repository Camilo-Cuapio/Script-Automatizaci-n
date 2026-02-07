package proyecto_coltomex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prueba1 {
    private WebDriver driver;
//cambios a realizar

    //cambios 2
    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
// cambio 3
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
//PRUEBA JENKINS
    }
    
}

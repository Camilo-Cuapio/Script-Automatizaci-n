package proyecto_coltomex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlujoPrincipal {

    private WebDriver driver;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");


    }
// ingresar usuario, contraseña
    @Test
   public void logeoCttrack() throws InterruptedException {
        /*WebElement usuaCttrack = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        usuaCttrack.clear();
        usuaCttrack.sendKeys("standard_user");
        WebElement pasCttrack = driver.findElement(By.cssSelector("#password"));
        pasCttrack.clear();
        pasCttrack.sendKeys("secret_sauce");

      //Tomar evidencia
        File screenshotFile = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("1Login_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
// Dar clic en el botón de enter
        WebElement btentrar = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        btentrar.click();
//Tomar evidencia
        File screenshotFileeee = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFileeee, new File("2entrar pagina_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
// Selecciónar del listado de opciones
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();

        Select ltctt = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        ltctt.selectByVisibleText("Name (Z to A)");
//Tomar evidencia
        File screenshotFileee = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFileee, new File("3Seleccipnaropcion_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);*/


        driver.findElement(By.xpath("//*[@id=\"dob\"]")).click();

        Select month_drp = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")));
        month_drp.selectByVisibleText("Oct");

        Select year_drp = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")));
        year_drp.selectByVisibleText("1990");

        String date = "15";
        //List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td"));
        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equals(date)) {
                ele.click();
                break;


            }

        }
        //Tomar evidencia
        File screenshotFile = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("1Login_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

}
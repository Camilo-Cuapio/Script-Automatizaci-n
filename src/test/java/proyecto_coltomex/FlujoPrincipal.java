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

//Ingresar Fecha automatizada
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
        //prueba jenkins
        //pruebas triggers
//Segunda prueba con trigger webhook desde git y validar allure reports

    }

}
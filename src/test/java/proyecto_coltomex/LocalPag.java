package proyecto_coltomex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocalPag {
    private WebDriver driver;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        driver.get("file:///C:/Users/DELL/Documents/Test%20local/Prueba.html");

    }

    // Pruebas en pagina local
    @Test
    public void logeoCttrack() throws InterruptedException {
        WebElement usuaCttrack = driver.findElement(By.name("usuario"));
        usuaCttrack.clear();
        usuaCttrack.sendKeys("standard_user");
        WebElement pasCttrack = driver.findElement(By.name("password"));
        pasCttrack.clear();
        pasCttrack.sendKeys("secret_sauce");

        //Tomar captura
        File screenshotFile = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("1Login_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        // Clic en el boton

        WebElement btentrar = driver.findElement(By.id("btnEntrar"));
        btentrar.click();

        //Tomar evidencia
        File screenshotFilee = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFilee, new File("2enter_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);


        //Selecciónar listado de opciones----------------------

        driver.findElement(By.id("tipoDocumento")).click();

        Select ltctt = new Select(driver.findElement(By.xpath("//*[@id=\"dropdownOptions\"]")));
        ltctt.selectByVisibleText("seleccionarOpcion('Hoja ruta')");

        // Tomar captura
        File screenshotFileee = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFileee, new File("3listadesplega_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        //Ingresar fecha

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

        //Tomar captura
        File screenshotFileeee = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFileeee, new File("1Login_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        //Prueba Jenkins solo realiza cambios
        // realización
    }
}
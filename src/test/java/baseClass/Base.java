package baseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

// Clase Base
public class Base {
    // Creamos el driver de tipo WebDriver
    public static WebDriver driver;

    // Creamos el constructor de la clase Base y recibe como parametro el driver
    public Base(WebDriver driver) {
        // Asignamos el driver de la clase
        Base.driver = driver;
    }

    // Creamos nuestro chromeDriver
    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    // Creamos un metodo para parametrizar nuestro get
    public void visit(String url) {
        driver.get(url);
    }

    // Creamos un metodo para parametrizar nuestro findElement
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Creamos un metodo para parametrizar nuestro click
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Creamos un metodo para parametrizar nuestro getText
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Creamos un metodo para parametrizar nuestro fluentWait
    public void fluentWait(By locator) {
        Wait<WebDriver> fluWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
        fluWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

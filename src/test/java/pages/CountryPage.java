package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import baseClass.Base;

// Clase CountryPage que hereda la clase Base
public class CountryPage extends Base {
    // Locators utilizando el By para referenciar sus paths
    By loc_countryForm = By.className("wrapperTwo");
    By loc_chkTerms = By.xpath("//input[@type='checkbox']");
    By loc_btnProceed = By.xpath("//input[@type='checkbox']");
    By loc_sltCountry = By.xpath("//div[@class='wrapperTwo']/div/select");

    // Creamos una instancia de la clase CountryPage para no perder el driver
    private static CountryPage instance = new CountryPage();

    // Creamos el constructor de la clase CountryPage, sin el parametro driver ya que ahora solo necesitamos la instancia
    public CountryPage() {
        super(driver);
    }

    // Creamos el metodo para obtener y retornar la instancia de la clase CartPage
    public static CountryPage getInstance() {
        return instance;
    }
    
    // Creamos el metodo para esperar que el form y el select carguen los valores 
    public void waitForCountryForm() {
        // Llamamos el metodo fluentWait de la clase Base y le enviamos el locator como parametro
        fluentWait(loc_countryForm);
    }
    
    // Creamos el metodo para seleccionar el pais
    public void selectCountry() {
        // Creamos el select y llamamos el findElement de la clase Base con el locator como parametro
        Select loc_ddCountry = new Select(findElement(loc_sltCountry));
        loc_ddCountry.selectByValue("Costa Rica");
    }
    
    // Creamos el metodo para aceptar los terms
    public void clickAgreeTerms() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_chkTerms);
    }
    
    // Creamos el metodo para proceder con la orden
    public void clickProceedButton() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_btnProceed);
    }
}

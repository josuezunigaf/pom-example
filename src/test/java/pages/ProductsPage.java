package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.Base;

// Clase ProductsPage que hereda la clase Base
public class ProductsPage extends Base{
    // Locators utilizando el By para referenciar sus paths
    By loc_productsForm = By.className("products");
    By loc_brocolliButton = By.xpath("//div[@class='products']/div[1]/div[3]/button");
    By loc_cauliflowerButton = By.xpath("//div[@class='products']/div[2]/div[3]/button");
    By loc_cartButton = By.xpath("//a[@class='cart-icon']/img");
    By loc_cartProceedButton = By.xpath("//div[@class='action-block']/button");
    
    // Creamos el constructor de la clase ProductsPage y recibe como parametro el driver
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    
    // Creamos el metodo para esperar que los productos se muestren
    public void initialLoad() {
        // Llamamos el metodo fluentWait de la clase Base y le enviamos el locator como parametro
        fluentWait(loc_productsForm);
    }
    
    // Creamos el metodo para anadir los productos
    public void addProducts() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_brocolliButton);
        click(loc_cauliflowerButton);
    }
    
    // Creamos el metodo para mostrar el carrito
    public void clickCart() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_cartButton);
    }
    
    // Creamos el metodo para proceeder al pago
    public void clickCartProceed() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_cartProceedButton);
    }
}

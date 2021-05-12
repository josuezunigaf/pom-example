package pages;

import org.openqa.selenium.By;

import baseClass.Base;

// Clase CartPage que hereda la clase Base
public class CartPage extends Base {
    // Locators utilizando el By para referenciar sus paths
    By loc_cartTable = By.id("productCartTables");
    By loc_lblFirstProductName = By.xpath("//table[@id='productCartTables']/tbody/tr[1]/td[2]/p");
    By loc_lblSecondProductName = By.xpath("//table[@id='productCartTables']/tbody/tr[2]/td[2]/p");
    By loc_lblTotalAmount = By.xpath("//div[@class='products']/div/span[3]");
    By loc_btnPlaceOrder = By.xpath("//div[@class='products']/div/button");
    
    // Creamos una instancia de la clase CartPage para no perder el driver
    private static CartPage instance = new CartPage();
    
    // Creamos el constructor de la clase CartPage, sin el parametro driver ya que ahora solo necesitamos la instancia
    public CartPage() {
        super(driver);
    }
    
    // Creamos el metodo para obtener y retornar la instancia de la clase CartPage
    public static CartPage getInstance() {
        return instance;
    }
    
    // Creamos el metodo para esperar que los productos se muestren en la tabla del carrito
    public void waitForCartTable() {
        // Llamamos el metodo fluentWait de la clase Base y le enviamos el locator como parametro
        fluentWait(loc_cartTable);
    }
    
    // Creamos el metodo para obtener el texto del primer producto
    public String getTextFirstProduct() {
        // Llamamos el getText de la clase Base con el locator como parametro y retornamos el texto
        return getText(loc_lblFirstProductName);
    }
    
    // Creamos el metodo para obtener el texto del segundo producto
    public String getSecondProduct() {
        // Llamamos el getText de la clase Base con el locator como parametro y retornamos el texto
        return getText(loc_lblSecondProductName);
    }
    
    // Creamos el metodo para obtener el texto del monto total
    public String getTotalAmount() {
        // Llamamos el getText de la clase Base con el locator como parametro y retornamos el texto
        return getText(loc_lblTotalAmount);
    }
    
    // Creamos el metodo para confirmar la orden
    public void clickPlaceOrder() {
        // Llamamos el metodo click de la clase Base y le enviamos el locator como parametro
        click(loc_btnPlaceOrder);
    }
}

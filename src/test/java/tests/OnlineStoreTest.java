package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.CountryPage;
import pages.ProductsPage;

// Anotacion junit 4 para correr tests de forma ordenada por nombre_ascendente
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OnlineStoreTest {
    // Creamos el driver de tipo WebDriver
    public static WebDriver driver;
    // Creamos los objetos para cada una de las clases 
    static ProductsPage productsPage;
    static CartPage cartPage;
    static CountryPage countryPage;
    
    // Anotacion para el setUp
    @BeforeClass
    public static void setUp() {
        /* El productsPage va a ser un objeto de la clase ProductsPage y le enviamos el driver por ser 
        la primer pagina que necesitamos abrir */
        productsPage = new ProductsPage(driver);
        /* Una vez enviado el driver, necesitamos mantenerlo en las otras paginas, entonces obtenemos 
        las instancias de cada clase */
        cartPage = CartPage.getInstance();
        countryPage = CountryPage.getInstance();
        // Seteamos las propiedades que va a tener el driver
        driver = productsPage.chromeDriverConnection();
        // Iniciamos la prueba abriendo la URL con el metodo visit de la clase Base
        productsPage.visit("https://rahulshettyacademy.com/seleniumPractise/");
        // Llamamos el metodo initialLoad de la clase ProductsPage
        productsPage.initialLoad();
    }
    
    // Anotacion para terminar la ejecucion de forma segura
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    
    // Step 01 para anadir los productos
    @Test
    public void step01_addProductsToCart() {
        // Llamamos el metodo addProducts de la clase ProductsPage
        productsPage.addProducts();
    }
    
    // Step 02 para abrir el carrito
    @Test
    public void step02_clickCart() {
        // Llamamos el metodo clickCart de la clase ProductsPage
        productsPage.clickCart();
    }
    
    // Step 03 para proceder con la orden
    @Test 
    public void step03_clickCartProceed() {
        // Llamamos el metodo clickCartProceed de la clase ProductsPage
        productsPage.clickCartProceed();
    }
    
    // Step 04 para validar la URL
    @Test 
    public void step04_assertUrl() {
        // Llamamos el metodo waitForCartTable de la clase CartPage para esperar que cargue la tabla
        cartPage.waitForCartTable();
        // Obtenemos la URL actual y la comparamos
        Assert.assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/cart", driver.getCurrentUrl());
    }
    
    // Step 05 para validar los productos y el total
    @Test
    public void step05_assertCorrectProducts() {
        // Comparamos los productos/info llamando los metodos de la clase CartPage
        Assert.assertEquals("Brocolli - 1 Kg", cartPage.getTextFirstProduct());
        Assert.assertEquals("Cauliflower - 1 Kg", cartPage.getSecondProduct());
        Assert.assertEquals("180", cartPage.getTotalAmount());
    }
    
    // Step 06 para confirmar la orden
    @Test
    public void step06_placeOrder() {
        // Llamamos el metodo clickPlaceOrder de la clase CartPage
        cartPage.clickPlaceOrder();
    }
    
    // Step 07 para seleccionar el pais y proceder
    @Test
    public void step07_chooseCountry() {
       // Llamamos el metodo waitForCountryForm de la clase CountryPage para esperar que cargue
       countryPage.waitForCountryForm();
       // Llamamos los metodos de la clase CountryPage para los ultimos pasos
       countryPage.selectCountry();
       countryPage.clickAgreeTerms();
       countryPage.clickProceedButton();
    }
}

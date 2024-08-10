package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void IniciarSession(){
        this.driver.findElement(LoginPage.IniciarSession).click();
    }

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));


    }

//    public void validarLogo(){
//        WebElement lblTitle = driver.findElement(LoginPage.lblTitle);
//        System.out.println(lblTitle.getText());
//        Assertions.assertEquals(lblTitle.getText(),"Swag Labs");
//    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }
    public void Categoria(String categoria){
        this.driver.findElement(By.linkText(categoria)).click();
    }
    public void Subcategoria(String subcategoria){
        this.driver.findElement(By.linkText(subcategoria)).click();
    }
    public void AgregarUnidades(String cantidades){
        this.driver.findElement(LoginPage.producto).click();
        WebElement userInputElement = driver.findElement(LoginPage.cantidad);
        userInputElement.sendKeys(Keys.CONTROL + "a");
        userInputElement.sendKeys(Keys.BACK_SPACE);
        userInputElement.sendKeys(cantidades);
        screenShot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(LoginPage.Añadir).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void TituloPop(){

        WebElement lblTitle = driver.findElement(LoginPage.PopConfirmacion);
        Assertions.assertEquals(lblTitle.getText(),"\uE876Producto añadido correctamente a su carrito de compra");
    }
    public void ValidaMontoTotal(){
        WebElement lblTitle = driver.findElement(LoginPage.PopTotal);
        Assertions.assertEquals(lblTitle.getText(),"38,24 PEN");
    }

    public void FinalizarCompra(){
        this.driver.findElement(LoginPage.FinalizarCompra).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ValidaTituloCarrito(){
        WebElement lblTitle = driver.findElement(LoginPage.TituloCarrito);
        Assertions.assertEquals(lblTitle.getText(),"CARRITO");
    }

    public void ValidarPrecioCarrito(){
        WebElement lblTitle = driver.findElement(LoginPage.CalculoPrecioCarrito);
        Assertions.assertEquals(lblTitle.getText(),"38,24 PEN");
    }

}

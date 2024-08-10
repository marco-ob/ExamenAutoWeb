package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStepsDef {

    private WebDriver driver;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.IniciarSession();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
        loginSteps.login();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.Categoria(categoria);
        screenShot();
        loginSteps.Subcategoria(subcategoria);
        screenShot();


    }

    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.AgregarUnidades(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.TituloPop();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ValidaMontoTotal();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.FinalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ValidaTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ValidarPrecioCarrito();
        screenShot();
    }
}

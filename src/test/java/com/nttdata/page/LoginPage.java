package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {


    public static By IniciarSession = By.linkText("Iniciar sesión");
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By producto = By.xpath("//*[@id='js-product-list']/div[1]/div/article/div/div[1]/a/picture/img");
    public static By cantidad = By.id("quantity_wanted");
    public static By Añadir = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button");
    public static By PopConfirmacion = By.id("myModalLabel");
    public static By PopTotal = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By FinalizarCompra = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a");
    public static By TituloCarrito = By.xpath("//*[@id='main']/div/div[1]/div/div[1]/h1");
    public static By CalculoPrecioCarrito = By.xpath("//*[@id='main']/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");



}

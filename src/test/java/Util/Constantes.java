package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alejo
 */
public class Constantes {

    protected static WebDriver driver;
    protected static WebElement elementoCapturado;
    protected static WebElement BotonAdd;
    protected static String NavegadorChrome = "webdriver.chrome.driver";
    protected static String RutaNavegadorChrome = "chromedriver_win32\\chromedriver.exe";
    
    //Esta url cambia cada que se ejecuta el proyecto
    protected static String URLBase ="http://localhost:7139/Views/Vehiculos";
    public Constantes() {
    }

}

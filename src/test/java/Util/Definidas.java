/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import static Util.Constantes.NavegadorChrome;
import static Util.Constantes.RutaNavegadorChrome;
import static Util.Constantes.driver;
import static Util.Constantes.elementoCapturado;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author alejo
 */
public class Definidas extends Util.Constantes {

    public Definidas() {

    }

    public void ingresarALaUrl(String url) throws Throwable {
        System.setProperty(NavegadorChrome, RutaNavegadorChrome);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    
    public static void encontrarElementoXpath(String xpathCampo) {
        elementoCapturado = driver.findElement(By.xpath(xpathCampo));
    }

    public static void iniciarSesionConUsuarioYClave(String Usuario, String Clave) {
        elementoCapturado = driver.findElement(By.name("user"));

        elementoCapturado.sendKeys(Usuario);

        elementoCapturado = driver.findElement(By.name("password"));

        elementoCapturado.sendKeys(Clave);

    }

    public static void esperarSegundos(int Segundos) throws InterruptedException {
        Thread.sleep(1000 * Segundos);
    }

    //tener en cuenta que se puede poner una definida para esta sola al igual qu eel login definadas para login o asi.
    public static void AgregarAlCarritoDeComprasLibrosDeseados(int CantidadCoreJava, int CantidadRubyForRails, int CantidadPythonCookbook) throws InterruptedException {
        //capturar elemento de la caja de texto CoreJava
        Definidas.encontrarElementoXpath("/html/body/center/form/div/table/tbody/tr[2]/td[4]/input");
        elementoCapturado.clear();
        elementoCapturado.sendKeys(String.valueOf(CantidadCoreJava));

        //capturar elemento de la caja de texto RubyForRails
        Definidas.encontrarElementoXpath("/html/body/center/form/div/table/tbody/tr[3]/td[4]/input");
        elementoCapturado.clear();
        elementoCapturado.sendKeys(String.valueOf(CantidadRubyForRails));

        //capturar elemento de la caja de texto PythonCookbook
        Definidas.encontrarElementoXpath("/html/body/center/form/div/table/tbody/tr[4]/td[4]/input");
        elementoCapturado.clear();
        elementoCapturado.sendKeys(String.valueOf(CantidadPythonCookbook));

    }

    //compras
    public static void validarQueElValorTotalSeaCorrectoSegunProductosAgregados(String Total) throws InterruptedException {

        int total = Integer.parseInt(Total);

        elementoCapturado = driver.findElement(By.id("total"));
        int TotalTemporal = Integer.parseInt(elementoCapturado.getAttribute("value"));

        if (total != TotalTemporal) {
            System.err.println("No se realizo el calculo correctamente, " + "El total es: " + Total);

        } else {
            System.out.println("Se realizo el calculo correctamente, " + "El total es: " + Total);

        }
        assertTrue(driver.findElement(By.id("total")).getAttribute("value").contains(String.valueOf(Total)));
    }

   
}

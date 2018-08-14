/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import static Util.Constantes.driver;
import Util.Definidas;
import static junit.framework.TestCase.assertTrue;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author alejo
 */
public class AgregarVehiculos extends Util.Constantes{
    
    
    Util.Definidas definidas = new Util.Definidas();
    
    @Before
    public void SetUp() throws Throwable
    {
         definidas.ingresarALaUrl(URLBase);
    }
    
    @Test
    public void TestAlRegistrarUnVehiculoDebeAvisarleAlUsuarioQueFueExitosoElRegistro() throws Throwable
    {
       
        //para crear numeros aleatorios para guardar una placa diferente
        int numeroAleatorio = (int) (Math.random() * 4567) + 1;
       
        
        
        //se captura el elemento con driver y su ID y posteriormente se guarda en elementoCapturado
        elementoCapturado = driver.findElement(By.id("MainContent_txtPlaca"));
        elementoCapturado.sendKeys(String.valueOf(numeroAleatorio)); // se escribe en el campo el numero aleatorio
        
        
        /* se captura de nuevo el elemento, si no se hace, queda recordando el anterior, se recomienda que si se hacen varios test a una pantalla capturar
        Los elementos por variable de forma global para que se declaren solo 1 vez, para no declararlos de nuevo, en este caso como 
        era un ejemplo con el fin de ilustrar y mostrar como funciona se declaran en todos los test*/
        
        elementoCapturado = driver.findElement(By.id("MainContent_txtColor"));
        elementoCapturado.sendKeys("Rojo");
        

        
        Select selectPropietario = new Select(driver.findElement(By.id("MainContent_cboPropietario")));
        selectPropietario.selectByVisibleText("Pedro");
        
        Select selectCarga = new Select(driver.findElement(By.id("MainContent_cboCarga")));
        selectCarga.selectByVisibleText("Balones");
        
        elementoCapturado = driver.findElement(By.id("MainContent_btnRegistrar"));
        elementoCapturado.click();
        
        assertTrue(driver.findElement(By.id("MainContent_lblError")).getText().contains("Dato ingresado correctamente"));
        
    }
    
    
     @Test
    public void TestIntentarRegistrarAUnVehiculoQueYaTieneMasDeTresCargasPermitidasDebeAvisarAlUsuarioConUnMensaje() throws Throwable
    {
        elementoCapturado = driver.findElement(By.id("MainContent_txtPlaca"));
        elementoCapturado.sendKeys("01s12");
        
        
        elementoCapturado = driver.findElement(By.id("MainContent_txtColor"));
        elementoCapturado.sendKeys("Rojo");
        

        
        Select selectPropietario = new Select(driver.findElement(By.id("MainContent_cboPropietario")));
        selectPropietario.selectByVisibleText("Pedro");
        
        Select selectCarga = new Select(driver.findElement(By.id("MainContent_cboCarga")));
        selectCarga.selectByVisibleText("Balones");
        
        elementoCapturado = driver.findElement(By.id("MainContent_btnRegistrar"));
        elementoCapturado.click();
        definidas.esperarSegundos(3);
        
        assertTrue(driver.findElement(By.id("MainContent_lblError")).getText().contains("Maximo de cargas disponibles agotadas"));
    }
    
     @Test
    public void TestIntentarRegistrarAUnVehiculoQueYaTieneUnPropietarioDebeAvisarAlUsuarioConUnMensaje() throws Throwable
    {
        elementoCapturado = driver.findElement(By.id("MainContent_txtPlaca"));
        elementoCapturado.sendKeys("01s12");
        
        
        elementoCapturado = driver.findElement(By.id("MainContent_txtColor"));
        elementoCapturado.sendKeys("Rojo");
        

        
        Select selectPropietario = new Select(driver.findElement(By.id("MainContent_cboPropietario")));
        selectPropietario.selectByVisibleText("Pedro");
        
        Select selectCarga = new Select(driver.findElement(By.id("MainContent_cboCarga")));
        selectCarga.selectByVisibleText("Balones");
        
        elementoCapturado = driver.findElement(By.id("MainContent_btnRegistrar"));
        elementoCapturado.click();
        definidas.esperarSegundos(3);
     
        assertTrue(driver.findElement(By.id("MainContent_lblError")).getText().contains("Este vehiculo con placa 01s12 ya tiene un propietario, no se puede agregar mas de 1"));
    }
    
    @Test
    public void TestIntentarPresionarBotonRegistrarSinLlenarCamposDebeAvisarAlUsuarioQueDebeLlenarLosDatos() throws Throwable
    {
      
        elementoCapturado = driver.findElement(By.id("MainContent_btnRegistrar"));
        elementoCapturado.click();
        definidas.esperarSegundos(3);
     
        assertTrue(driver.findElement(By.id("MainContent_lblError")).getText().contains("Debe llenar placa y color"));
    }
    @After
    public void finalizar()
    {
        driver.quit();
    }
}

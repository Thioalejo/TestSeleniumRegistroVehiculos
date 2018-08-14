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
       
        int numeroAleatorio = (int) (Math.random() * 4567) + 1;
       
        elementoCapturado = driver.findElement(By.id("MainContent_txtPlaca"));
        elementoCapturado.sendKeys(String.valueOf(numeroAleatorio));
        
        
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

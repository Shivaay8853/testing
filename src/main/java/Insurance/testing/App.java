package Insurance.testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;


public class App {

    
    public static void main( String[] args ) throws InterruptedException, IOException{
		    
        System.out.println( "Script started" );
	        //initilizing the web driver
	    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\softewere\\chromedriver-win64\\chromedriver-win64\\chromedriver"); 
	    WebDriverManager.chromedriver().setup();
	    
	    //setting properties
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
      
        
        //open url
	    System.out.println("Driver opening up the url in browser");
        WebDriver driver = new ChromeDriver(chromeOptions); // Remove chromeOptions here
	    driver.get("http://3.145.199.75:8081/contact.html");

	    
	    //invole imlicit waits to load the page
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    System.out.println("Enter details in the form");
	    
	    //enter details
	    driver.findElement(By.id("inputName")).sendKeys("RADHE SHYAM");
	    Thread.sleep(2000);
	    driver.findElement(By.id("inputNumber")).sendKeys("8924972997");
	    Thread.sleep(2000);
	    driver.findElement(By.id("inputMail")).sendKeys("sonusingh.kunder@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("inputMessage")).sendKeys("i am intrested");
	    Thread.sleep(2000);
	     
	    driver.findElement(By.id("my-button")).click();
	  
	    String response = driver.findElement(By.id("response")).getText();
	   
	    System.out.println(response);
	   
	    System.out.println("text scripts are executed");
	    
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
	    
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("C:\\Users\\user\\Downloads\\test-reports.jpg");
        FileUtils.copyFile(srcFile, destFile);
	    	    
	    driver.quit();
        
        System.out.println("hello world");
   
    
       }
	
  }
    


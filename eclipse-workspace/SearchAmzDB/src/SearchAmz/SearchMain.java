package SearchAmz;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 

//Import Database Connection Class file 
//import DatabaseConnection; 

//public class SearchMain {
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.firefox.FirefoxDriver;
	//comment the above line and uncomment below line to use Chrome
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.By;
	//import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.firefox.FirefoxDriver;
	//import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.remote.RemoteWebDriver;
	//import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.Dimension;
	//import org.openqa.selenium.WebElement;
	//import org.openqa.selenium.interactions.Actions;
	//import org.openqa.selenium.support.ui.ExpectedConditions;
	//import org.openqa.selenium.support.ui.WebDriverWait;
	//import org.openqa.selenium.JavascriptExecutor;
	//import org.openqa.selenium.Alert;
	//import org.openqa.selenium.Keys;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.Set;

	public class AmazonMobilesTest {
		private static WebDriver driver;
		
	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver","/home/madhuriadapalag/Downloads/chromedriver");
		    driver = new ChromeDriver();
	    	
	        String baseUrl = "http://www.amazon.in";
	       
	        
	        
	        // launch  and direct it to the Base URL
	        driver.get(baseUrl);

	        try {
	        driver.manage().window().maximize();
	        Thread.sleep(4000);
	  
	       driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
	       Thread.sleep(9000);
	       //driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).submit();
	       //Thread.sleep(2000);
	       //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
	        //Thread.sleep(4000);
	        driver.findElement(By.className("nav-input")).submit();
	        Thread.sleep(4000);
	        //driver.findElement(By.partialLinkText("Apple iPhone 11")).click(); 
	        driver.findElement(By.partialLinkText("iPhone")).click();
	        Thread.sleep(9000);
	        
	       
	        }
	        catch (Exception e1) {
	        	e1.printStackTrace();
	        }
	        
	        
	        
	       
	        //close Chrome
	        driver.close();
	       
	    }
	    
	 

	}
	    }

//}

package AmazonTesting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class InsertData {

    public static void main(String[] args) throws ParseException {
    		
    	System.setProperty("webdriver.chrome.driver","/home/madhuriadapalag/Downloads/chromedriver");
    	String baseUrl = "http://www.amazon.in";
	          
        
        // launch  and direct it to the Base URL
        
    	
    	WebDriver wd1 = new ChromeDriver();	
    	wd1.get(baseUrl);
    	//case a. Use the Mobiles tab
    	//wd1.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
	    //Thread.sleep(000);
    	
    	//case b. Directly access the Search page after looking up iPhone
        //wd1.get("https://www.amazon.in/s?k=iPhone&ref=nb_sb_noss_2"); 
    	//Thread.sleep(2000);
    	
    	//case c. Searching the twotabsearchbox
	    wd1.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        wd1.findElement(By.className("nav-input")).submit();
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       /* //driver.findElement(By.partialLinkText("Apple iPhone 11")).click(); 
	       wd1.findElement(By.partialLinkText("iPhone")).click();
	        try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        //No.of Columns
        List <WebElement>  rows = wd1.findElements(By.xpath(".//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div"));
        		
        System.out.println("No of rows are : " +rows.size()); 
        
        WebElement row = null;
        //List <WebElement> columns;
        WebElement column;
        WebElement costcolumn;
	    int i=0;
	   
	    //String xp;
	    for (i=1;i<rows.size();i++) {
	    	row = rows.get(i);
	    	int c = i+1;
	    	String namepath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+c+"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";
	    	String costpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div["+c+"]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div/a/span[1]/span[2]/span[2]";
	    	//System.out.println(xpath);
	    	try
	    	{
	    	column = row.findElement(By.xpath(namepath));
	    	costcolumn = row.findElement(By.xpath(costpath));
	    	String name = column.getText();
	    	String cost = costcolumn.getText();
	    	
	    	System.out.println("RowText value is : " + column.getText());
	    	System.out.println("RowText value is : " + costcolumn.getText());
	    	
	    	DBConnection d1 = new DBConnection();
	    	AmazonProduct p1 = new AmazonProduct(i, name, cost);
	    	d1.insertRecord(p1);
	    	}
	    	catch(Exception ex)
	    	{}
	    	finally
	    	{
	    		
	    	}
	    	
	    }
	    	wd1.close();
	    } 
       
    }

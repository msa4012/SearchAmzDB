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



public class InserData {
	public static void InsertRecord(String id, String name)
	{
		Connection con;
    	try {
    		try {
				con = DatabaseConnection.initializeDatabase();
				String query2 = "Insert into jdbctesting.list_tbl (list_id, list_name) values (?,?)";
		    	PreparedStatement pstmt;
		    	
		    	
					pstmt = con.prepareStatement(query2);
				
				System.out.println("ID:");
				pstmt.setString(1,id);
				System.out.println("Namesss:");
				pstmt.setString(2, name);
				
				
				int ret = pstmt.executeUpdate();
				if (ret == 1) {
					System.out.println("Successfully added a new record");
				}
				else {
					System.out.println("Unable to add a new record");
				}
		    	
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
	}
    public static void main(String[] args) throws ParseException {
    	
    	  	
    	
    	
    	System.setProperty("webdriver.chrome.driver","/home/madhuriadapalag/Downloads/chromedriver");
    	
    	WebDriver wd1 = new ChromeDriver();	
        wd1.get("https://www.google.com/search?ei=YE2UX9bjEtTBytMP0fKIuAU&q=list+of+state+capitals+in+usa&oq=list+of+state+capitals+&gs_lcp=CgZwc3ktYWIQAxgBMgUIABDJAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADoHCAAQRxCwAzoECAAQQzoFCAAQkQI6CwguELEDEMcBEKMCOgUIABCxAzoFCC4QsQM6CAguELEDEIMBOggIABDJAxCRAjoICAAQsQMQgwE6BwgAEMkDEEM6CAgAELEDEMkDSgYIBBICMTlKBQgIEgExSgUICRIBMVD_aljzhgFgn6cBaAJwAHgAgAHQAYgB3giSAQYyMS4xLjGYAQCgAQGqAQdnd3Mtd2l6yAEIwAEB&sclient=psy-ab");         
        //No.of Columns
        List <WebElement>  rows = wd1.findElements(By.xpath(".//*[@id=\"rso\"]/div[1]/div[1]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr"));
        System.out.println("No of rows are : " +rows.size()); 
        
        WebElement row;
        List <WebElement> columns;
        WebElement column;
	    int i=0;
	   
	    String xp;
	    for (i=1;i<rows.size();i++) {
	    	row = rows.get(i);
	    	int c = i+1;
	    	columns = row.findElements(By.xpath("//*[@id=\"rso\"]/div[1]/div[1]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr["+c+"]/td"));
	    	System.out.println("RowText value is : " + rows.get(i).getText());
	    	System.out.println("Col Count value is : " + columns.size());
	    	
	    	String state = columns.get(0).getText(); 
	    	String capital = columns.get(1).getText();
	    	InsertRecord(state,capital);
	    	 int j=0;
	    	for (j=0;j<columns.size();j++) {
	    	column = columns.get(j);
	    	System.out.println("Col is : " + column.getText());
	    	}
	    } 
       
       // wd.close();
    }
}
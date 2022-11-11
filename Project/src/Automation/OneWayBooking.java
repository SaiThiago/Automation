package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OneWayBooking {

	public static void main(String[] args) throws InterruptedException {
		//String departureString = "24 Oct 2022";
		String dep_month = "December";
		String dep_year = "2022";
		String dep_date = "24";

		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		Thread.sleep(2000);
		
		//SELECTING DEPARTURE LOCATION AND THE ARRIVAL LOCATION
		WebElement departLocation = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/div[1]/div/div[1]/div/div/input"));
		departLocation.click();
		departLocation.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		departLocation.sendKeys("Chennai");
		departLocation.sendKeys(Keys.ENTER);
		
		WebElement arrLocation = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/div[1]/div/div[2]/div/div/input"));
		arrLocation.sendKeys("Bengaluru");
		arrLocation.sendKeys(Keys.ENTER);
		
		
		WebElement depart = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/div/input"));
		actions.moveToElement(depart).click().build().perform();
		actions.moveToElement(depart).click().build().perform();

		while(true) {
			String month = driver.findElement(By.xpath("//*[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']/div/span[1]")).getText();
		    String year = driver.findElement(By.xpath("//*[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']/div/span[2]")).getText();
		    
		    if(month.equals(dep_month) && year.equals(dep_year)) {
		    	Thread.sleep(4000);
		    	driver.findElement(By.xpath("//*[@class=\"ui-datepicker-group ui-datepicker-group-first\"]/table/tbody/tr/td/a[contains(text()," + dep_date + ")]")).click();
		    	Thread.sleep(3000);
		    	break;
		    }
		    else {
		    	Thread.sleep(2000);
		    	WebElement nextbutton = driver.findElement(By.xpath("//body/div[@id='body']/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/a[1]"));
				actions.moveToElement(nextbutton).click().build().perform();
			}
		    
		}
		
		WebElement proceedButton = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/div[2]/div/div[3]/button"));
		proceedButton.click();
		
		
				
	}

}
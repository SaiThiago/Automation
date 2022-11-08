package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OneWayBooking {

	public static void main(String[] args) throws InterruptedException {
		String departureString = "24 Oct 2022";
		String dep_month = "October";
		String dep_year = "2022";
		String dep_date = "24";
		//System.out.println(LocalDate.now());
		//String datevalue = LocalDate.now().plusDays(3).toString();
		//System.out.println(datevalue);
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		Thread.sleep(2000);
		//WebElement depart = driver.findElement(By.xpath("//*[@name=\"or-depart\"]"));
		WebElement depart = driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/div/input"));
		actions.moveToElement(depart).click().build().perform();
		actions.moveToElement(depart).click().build().perform();
		//depart.sendKeys(departureString);

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
	}

}
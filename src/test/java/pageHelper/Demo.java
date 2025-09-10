package pageHelper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	

	public static void main(String arr[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.meilisearch.com/");
		WebElement search = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		search.sendKeys("spiderman");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> movies = driver.findElements(By.xpath("//li[@class='ais-Hits-item']//span[@class='ais-Highlight']"));
		int count = movies.size();
		System.out.println(count);
		
		
		List<WebElement> Year = driver.findElements(By.xpath("//li[@class='ais-Hits-item']//span[@class='text-sm']"));
		for(int i=0;i<Year.size();i++) {
			List<WebElement> movieName = driver.findElements(By.xpath("(//li[@class='ais-Hits-item']//span[@class='ais-Highlight'])["+(i+1)+"]//*"));
			String movie ="";
			for(WebElement ele : movieName) {
				movie=movie+ele.getText();
			}
			String year = Year.get(i).getText();
			System.out.println(movie+" "+year);
		}
	
	
	}

	
	
	
}



















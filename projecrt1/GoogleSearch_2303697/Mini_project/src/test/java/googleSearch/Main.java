package googleSearch.mini;

import com.utils.excelUtils;
import com.utils.driverSetup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws IOException {

		WebDriver driver;
		driver = driverSetup.getWebDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// path OF Excelfile
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\Sheet.xlsx";

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		// no. of links
		System.out.println("No. of links in 1st page ::" + links.size());

		// names of links
		for (WebElement lt : links) {
			if (lt.getText().equals("")) 
			{
				System.out.println("Link Name Not Available");
				
			} 
			else 
			{
				System.out.println("Link Name ::" + lt.getText());
			}

		}

		// set data in excel
		write.setData(links, filepath, "sheet1");

		// get Data from Excel
		String siteName = excelUtils.getCellData(filepath, "sheet1", 0, 0);

		// send Value to the InputBox
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(siteName);

		// Wait for search options to be visible

		WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

		// storing the search options

		List<WebElement> searchOptions = driver.findElements(By.xpath("//*[@class='wM6W7d']")); // error

		// total no. of options
		System.out.println("No. of searchoptions::" + searchOptions.size());

		// ScreenShot code
		File src = options.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\screenShotsOptions.png");
		FileUtils.copyFile(src, trg);

		// Print all search options
		for (int i = 0; i < searchOptions.size(); i++) 
		{
			System.out.println("Search Options onSite::" + searchOptions.get(i).getText());

		}

		write.setData(searchOptions, filepath, "sheet1");

		// click on search button
		driver.findElement(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")).click();

		// number of search resuls

		WebElement result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']")));
		System.out.println("Count of All " + printCount.count(result));

		// code for fullpage screen Shot

		TakesScreenshot all = (TakesScreenshot) driver;
		File src2 = all.getScreenshotAs(OutputType.FILE);
		File trg2 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\cognifull.png");

		FileUtils.copyFile(src2, trg2);

		// click on news

		driver.findElement(By.xpath("//a[normalize-space()='News']")).click();

		// wait to load news page
		WebElement newspg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']")));
		System.out.println("Count of news " + printCount.count(newspg));

		// screenshot
		TakesScreenshot news = (TakesScreenshot) driver;
		File src3 = news.getScreenshotAs(OutputType.FILE);
		File trg3 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\newspage.png");
		FileUtils.copyFile(src3, trg3);

		// click on Images
		driver.findElement(By.xpath("//a[normalize-space()='Images']")).click();

		// screenshot
		TakesScreenshot img = (TakesScreenshot) driver;
		File src4 = img.getScreenshotAs(OutputType.FILE);
		File trg4 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\imagepage.png");
		FileUtils.copyFile(src4, trg4);

		// click on Video
		driver.findElement(By.xpath("//a[normalize-space()='Videos']")).click();

		WebElement vidpage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']")));

		System.out.println("Count of Video " + printCount.count(vidpage));

		TakesScreenshot vid = (TakesScreenshot) driver;
		File src5 = vid.getScreenshotAs(OutputType.FILE);
		File trg5 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\videopage.png");
		FileUtils.copyFile(src5, trg5);

		driver.quit();

	}

}

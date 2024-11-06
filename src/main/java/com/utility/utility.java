package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class utility {

	public static FileInputStream fs = null;
	private static String browser;

	public static String readProperties(String key) throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\configProperties";
		fs = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fs);
		return p.getProperty(key);

	}

	public static void implicitWait(int wait, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

	}

	public static void explicitWaitOfElement(int wait, WebDriver driver, WebElement element) {
		try {
			WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(wait));
			explicit.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
  
    

	
	
	
	
		public static boolean explicitWaitOfElementVisible(int wait, WebDriver driver, WebElement element) {
			try {
				WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(wait));
				explicit.until(ExpectedConditions.visibilityOf(element));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	
		}

	public static void uploadFile() {
		try {
			Robot robot = new Robot();

			String Path = "C://Users//tirumalabhara.godav//Downloads//MyHomePage.zip";
			// Copy the file path to the clipboard
			String stringpath = Path.replace("//", "\\");
			StringSelection stringSelection = new StringSelection(stringpath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			// Wait a moment for the upload dialog to appear
			Thread.sleep(1000); // Adjust if necessary

			// Click on the filename input field using TAB navigation
			// Instead of hardcoding, find the right number of TABs needed

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(200); // Adjust delay if needed

			// Paste the file path from the clipboard
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file selection
			Thread.sleep(500); // Wait a moment before pressing Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void enterWindowCredentials() {
		try {
			Robot robot = new Robot();

String username="admin";
String password="admin";
String Credentials=username+":"+password;

// Copy the file path to the clipboard
			StringSelection stringSelection = new StringSelection(Credentials);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Wait a moment for the upload dialog to appear
			Thread.sleep(1000); // Adjust if necessary

	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V); // Paste the credentials
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // Simulate pressing Enter to submit
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

			
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void explicitWaitOfElementtoclickable(int wait, WebDriver driver, WebElement element) {
		WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(wait));
		explicit.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void alert(WebDriver driver)
	{
		
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public static boolean explicitWaitOfElementpresent(int wait, WebDriver driver, By locator) {
		try {
			WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(wait));
			explicit.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void dropdownSelectionByValue(WebDriver driver, WebElement element, String Obj) {
		Select s = new Select(element);
		s.selectByValue(Obj);

	}

	public static void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(element);
	
	}

	public static void switchtodefaultframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static String navigateToNewWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String RTPWindow : windowHandles) {
			if (!RTPWindow.equals(parentWindow)) {
				driver.switchTo().window(RTPWindow);
				driver.manage().window().maximize();
			}
		}
		return parentWindow;

	}

	public static boolean isImageBroken(String broken) throws IOException {
		// TODO Auto-generated method stub
		
		
		URL url=new URL(broken);
		HttpURLConnection httpurl=(HttpURLConnection)url.openConnection();
		httpurl.setRequestMethod("HEAD");
		int responsecode=httpurl.getResponseCode();
		return responsecode==200;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static boolean setPriceRange(int min, int max,WebDriver driver,WebElement element) throws IOException {
		// TODO Auto-generated method stub
		
		try
		{
			
			

			JavascriptExecutor js=(JavascriptExecutor)driver;
	        String script = "arguments[0].innerText = '" + min+"-"+max + "';";
	        js.executeScript(script, element);
			
			return true;

			
		}catch(Exception e)
		{
			return false;

		}
		
		
	}


}

package Login;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class KeyboardActions {

	public  void SendKeysClipboard( String value)
	{
		try {
			
			Robot _robot = new Robot();
			StringSelection _selection = new StringSelection(value);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(_selection,_selection);
			
			_robot.keyPress(KeyEvent.VK_CONTROL);
			_robot.keyPress(KeyEvent.VK_V);
			
			_robot.keyRelease(KeyEvent.VK_V);
			_robot.keyRelease(KeyEvent.VK_CONTROL);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void SendTabKey()
	{
		try {
			
			Robot _robot = new Robot();
			_robot.keyPress(KeyEvent.VK_TAB);
			_robot.keyRelease(KeyEvent.VK_TAB);

			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void InsertTextActions(WebDriver driver,WebElement element, String value) 
	{
		Actions  builder = new Actions(driver);
		builder.moveToElement(element)
		.click()
		.sendKeys(element,value)
		.build().perform();
		
	}
	
	public void InsertTextJavaScript(WebDriver driver, WebElement element, String value)
	{
		JavascriptExecutor _scriptexec = ((JavascriptExecutor)driver);
		//_scriptexec.executeScript("var ele=arguments[0]; window.setTimeOut(function() {ele.setAttribute('value','"+value+"');}, 4000)", element);
		_scriptexec.executeScript("arguments[0].setAttribute('value','"+value+"')", element);
		
	}
	
	public void EnterClikKeyboard()
	{
		try {
			Robot _robot = new Robot();
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void EnterClikSendKeys( WebElement element)
	{
		element.sendKeys(Keys.RETURN);
	}
	
	public void EnterClikJavaScript(WebDriver driver, WebElement element)
	{
		JavascriptExecutor _script = ((JavascriptExecutor)driver);
		_script.executeScript("arguments[0].click()", element);
	}

	public void EnterClikActions(WebDriver driver, WebElement element)
	{
		Actions _actions = new Actions(driver);
		_actions.moveToElement(element).sendKeys(element, Keys.RETURN).perform();
	}

	public void EnterclickMousePressandRelese(WebElement element)
	{
		
		try {
			
			Point coordinates =element.getLocation();
			Robot _robot = new Robot();
			_robot.mouseMove(coordinates.getX(),coordinates.getY());
			_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectDDByTextorIndex(WebElement element, String text, int... index)
	{
		Select ddselect = new Select(element);
		if(text != null) {
		ddselect.selectByVisibleText(text);
		}
		else 
		{
		ddselect.selectByIndex(index[0]);
		}
	}
	
	public void SelectDDByOnlyValue(WebElement element, String text)
	{
		Select ddselect = new Select(element);
		List<WebElement> _emelemts = ddselect.getOptions();
		
		for(WebElement ele:_emelemts)
		{
			String value =ele.getAttribute("value");
			System.out.println("DD Value is :" + value);
			if(value.equalsIgnoreCase(text))
			{
				ele.click();
				break;
			}
		}
	}
	
	public void SelectBootStrapDD(WebDriver driver, String ddpath, String ulpath)
	{
		Actions _actions = new Actions(driver);
		_actions.moveToElement(driver.findElement(By.xpath(ddpath))).perform();
		driver.findElement(By.xpath(ulpath)).click();
		//_actions.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Men']"))).perform();
		//driver.findElement(By.xpath("//div[@class='dropdownLinksBlock']/ul/li/a[text()='T-Shirts'][contains(@onclick,'Men')]")).click();
		/*dd.click();
		List<WebElement> options=dd.findElements(By.tagName("li"));
		for(WebElement ele : options)
		{
			if(ele.getAttribute("value").equalsIgnoreCase(text))
			{
				ele.click();
				break;
			}
		}*/
		
	}
	
	
}

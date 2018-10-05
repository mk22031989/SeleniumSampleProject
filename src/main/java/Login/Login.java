package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Login {
	public Login(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
	
    @FindBy(how = How.XPATH, using ="//span[text()='Wipro Limited']")
    public WebElement btnWiproLtd;
    
    @FindBy(how = How.ID, using = "userNameInput")
    public WebElement txtUserName;

    @FindBy(how = How.ID, using = "passwordInput")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "submitButton")
    public WebElement btnLogin;
    

    public void LoginPage(WebDriver driver,String userName, String password)
    {
         try {
         	//click on wipro login button
              btnWiproLtd.click();
              
              //using javascript Executor
              KeyboardActions _kactions = new KeyboardActions();
              _kactions.InsertTextJavaScript(driver, txtUserName, userName);
              _kactions.InsertTextJavaScript(driver, txtPassword, password);
              
              
              //using actions to send text
               //KeyboardActions _kactions = new KeyboardActions();
              //_kactions.InsertTextActions(driver, txtUserName, userName);
              //_kactions.InsertTextActions(driver, txtPassword, password);
              
            //Using Robot Class sending text 
            //KeyboardActions _kactions = new KeyboardActions();
			//_kactions.SendKeysClipboard(userName);
			//Thread.sleep(5000);
			//_kactions.SendTabKey();
		   // _kactions.SendKeysClipboard(password);
		    
		    //Normal way of sending text 
		     //txtUserName.sendKeys(userName);
		     // txtPassword.sendKeys(password);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
       
    }
    
    public void LoginUsingKeboardActions(String username, String Password)
    {
    	KeyboardActions _kactions = new KeyboardActions();
    	
    	
    	try {
    		_kactions.SendTabKey();
    		Thread.sleep(5000);


    		_kactions.EnterClikKeyboard();
    		_kactions.SendKeysClipboard(username);
        	_kactions.SendTabKey();
        	_kactions.SendKeysClipboard(Password);
        	_kactions.SendTabKey();
        	_kactions.EnterClikKeyboard();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

    public void SelectBootStrapDD(WebDriver driver, String id, String text)
    {
    	
    	KeyboardActions _kactions = new KeyboardActions();
    	_kactions.SelectBootStrapDD(driver, id, text);
    }
    
    public void ClickLogin()
    {
    	
        btnLogin.submit();
    }


}

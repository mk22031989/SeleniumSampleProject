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
    

    public void LoginPage(String userName, String password)
    {
    	//click on wipro login button
        btnWiproLtd.click();
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public void ClickLogin()
    {
        btnLogin.submit();
    }


}

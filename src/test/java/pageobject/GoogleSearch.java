package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	@FindBy(css="input.gLFyf")
	public WebElement  txtSearchBox;
	@FindBy(css="div.FPdoLc input[class=gNO89b]")
	public WebElement  btnSearch;
	@FindBy(css="div.SPZz6b")
	public WebElement  lbResult;
	
	
	public GoogleSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// tach cai pom ra khoi test
		// dev se thay doi nhieu, khi dev no sua code -. minh chi can sua file nay la ok
		// khong anh huong den file test cua minh
	}
}

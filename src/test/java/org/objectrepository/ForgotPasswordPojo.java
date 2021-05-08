package org.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class ForgotPasswordPojo extends BaseClass {

	public ForgotPasswordPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Forfghjk?')]")
	private WebElement linkForgotPassword;

	@FindBy(id = "identify_email")
	private WebElement txtMobileNumber;

	@FindBy(id = "did_submit")
	private WebElement btnSearch;

	@FindBy(xpath = "//div[contains(text(),'Please identify this account another way')]")
	private WebElement txtErrorMsg;

	public WebElement getLinkForgotPassword() {
		return linkForgotPassword;
	}

	public WebElement getTxtMobileNumber() {
		return txtMobileNumber;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}

}

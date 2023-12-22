package PageObjects;

import com.task.base.BaseTest;
import com.task.pages.ForgetPasswordPage;
import com.task.pages.loginpage;


public class PageObjects  extends BaseTest{
	
	//here i am creating object of all page classes and then the common class will holds object of all  page classes
	private loginpage ln;
	private ForgetPasswordPage fp;
	
	public loginpage getLoginPage() {
		if (ln == null) {
			ln = new loginpage(driver);
			
		}
		return ln;
	}
	
	public ForgetPasswordPage getForgotPassPage() {
		if (fp == null) {
			fp = new ForgetPasswordPage(driver);
			
		}
		return fp;
	}


}

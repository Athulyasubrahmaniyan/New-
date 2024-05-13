package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.SaucedemoPagepkg;

import utilities.SaucedemoUtili;

public class SaucedemoTestpkg {
	WebDriver driver;
	String baseurl="https://www.saucedemo.com";
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
@Test
public void test() throws Exception
{
	SaucedemoPagepkg ob=new SaucedemoPagepkg(driver);
	String xl="C:\\Users\\User\\Desktop\\Book2.xlsx";
	String Sheet="Sheet1";
	int rowcount=SaucedemoUtili.getRowCount(xl,Sheet);
	for(int i=1;i<=rowcount;i++)
	{
		String username=SaucedemoUtili.getcellvalues(xl,Sheet,i,0);
		System.out.println("username--"+username);
		String password=SaucedemoUtili.getcellvalues(xl, Sheet, i, 1);
		System.out.println("password--"+password);
		ob.setValues(username,password);
		ob.login();
	}
	ob.cart();
	ob.addcart();
	ob.details("Athulya","S","686001");
	ob.contimthd();
	ob.logout();
}
}

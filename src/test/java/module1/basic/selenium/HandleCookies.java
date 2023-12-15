package module1.basic.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		//1. How to getCookies
		Set<Cookie> allCookies=driver.manage().getCookies();
		System.out.println("Number of cookies present: "+allCookies.size());
		for(Cookie cookie:allCookies) {
			System.out.println("Cookie name "+cookie.getName()+"==>"+"Cookie Value"+cookie.getValue());
		}
		
		//2. How to addCookie
		Cookie objectCookie=new Cookie("Sanjeeb","86585021");
		driver.manage().addCookie(objectCookie);
		int size=driver.manage().getCookies().size();
		System.out.println("Number of cookies are: "+size);
		Cookie name=driver.manage().getCookieNamed("Sanjeeb");
		System.out.println(name);
		
		//3. How to deleteCookie
		driver.manage().deleteCookie(objectCookie);
		int size1=driver.manage().getCookies().size();
		System.out.println("Number of cookies are: "+size1);
		
		driver.manage().deleteCookieNamed("session-id");
		int size2=driver.manage().getCookies().size();
		System.out.println("Number of cookies are: "+size2);
		Set<Cookie> cover=driver.manage().getCookies();
		
		for(Cookie c:cover) {
			System.out.println("Cookies Name: "+c.getName()+"==>"+"Cookies Value: "+c.getValue());
		 }
		
		//How to deleteAllCookies
		System.out.println("Delete All Cookies");
		driver.manage().deleteCookieNamed("session");
		driver.manage().deleteAllCookies();
		int size3=driver.manage().getCookies().size();
		Set<Cookie> all=driver.manage().getCookies();
		System.out.println(size3);
		for(Cookie c:all) {
			System.out.println("Cookies Name: "+c.getName()+"==>"+"Cookies Value: "+c.getValue());
		}
		driver.close();
	}
}

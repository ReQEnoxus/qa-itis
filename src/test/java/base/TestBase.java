package base;

import dto.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public abstract class TestBase {
    private final String BASE_URL = "https://mobislenotes.com";

    static {
        System.setProperty("webdriver.gecko.driver", "E:\\GeckoDriver\\geckodriver.exe");
    }

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public abstract void testCase();

    protected void loginWith(Account account) {
        navigateTo("/");
        driver.findElement(By.name("username")).sendKeys(account.getEmail());
        driver.findElement(By.name("password")).sendKeys(account.getPassword());
        driver.findElement(By.name("login")).click();
    }

    protected void resizeWindow(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    protected void navigateTo(String pathComponents) {
        driver.get(BASE_URL + pathComponents);
    }


}

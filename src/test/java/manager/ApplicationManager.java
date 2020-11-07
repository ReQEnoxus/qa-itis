package manager;

import helpers.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    static {
        System.setProperty("webdriver.gecko.driver", "E:\\GeckoDriver\\geckodriver.exe");
    }

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private String baseUrl;
    private LoginHelper login;
    private NavigationHelper navigation;
    private NoteHelper note;
    private WindowHelper window;
    private FolderHelper folder;

    private ApplicationManager() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        baseUrl = "https://mobislenotes.com";
        login = new LoginHelper(this);
        navigation = new NavigationHelper(this);
        note = new NoteHelper(this);
        window = new WindowHelper(this);
        folder = new FolderHelper(this);
    }

    private static ThreadLocal<ApplicationManager> instance = new ThreadLocal<>();

    public static ApplicationManager getInstance() {
        if (instance.get() == null) {
            instance.set(new ApplicationManager());
        }
        return instance.get();
    }

    public void terminate() {
        driver.quit();
    }

    public FolderHelper folder() {
        return folder;
    }

    public WebDriver driver() {
        return driver;
    }

    public LoginHelper auth() {
        return login;
    }

    public NavigationHelper navigation() {
        return navigation;
    }

    public NoteHelper note() {
        return note;
    }

    public WindowHelper window() {
        return window;
    }

    public String baseUrl() {
        return baseUrl;
    }
}

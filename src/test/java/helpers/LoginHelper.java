package helpers;

import dto.Account;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void authWith(Account account) {
        manager.driver().manage().deleteAllCookies();

        while (true) {
            try {
                manager.driver().findElement(By.xpath("/html/body/div[3]/div[1]/section/div/form/div[1]/input")).sendKeys(account.getEmail());
                manager.driver().findElement(By.xpath("/html/body/div[3]/div[1]/section/div/form/div[2]/input")).sendKeys(account.getPassword());
                manager.driver().findElement(By.name("login")).click();
                break;
            } catch (NoSuchElementException e) {

            }
        }
    }

    public void logout() {
        manager.driver().findElement(By.id("username")).click();
        manager.driver().findElement(By.id("sign-out")).click();
        manager.driver().manage().deleteAllCookies();
        manager.driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public boolean isLoggedIn() {
        return !manager.driver().manage().getCookies().isEmpty();
    }

    public boolean isLoggedIn(String username) {
        return username.equals(manager.driver().findElement(By.id("username")).getText());
    }

    public String authenticatedEmail() {
        WebDriverWait wait = new WebDriverWait(manager.driver(), 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(
                manager.driver().findElement(By.id("username"))
                )
        );
        return manager.driver().findElement(By.id("username")).getText();
    }
}

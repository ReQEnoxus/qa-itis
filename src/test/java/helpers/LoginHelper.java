package helpers;

import dto.Account;
import manager.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void authWith(Account account) {
        manager.driver().findElement(By.name("username")).sendKeys(account.getEmail());
        manager.driver().findElement(By.name("password")).sendKeys(account.getPassword());
        manager.driver().findElement(By.name("login")).click();
    }
}

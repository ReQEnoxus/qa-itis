package helpers;

import dto.Folder;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class FolderHelper extends HelperBase {
    public FolderHelper(ApplicationManager manager) {
        super(manager);
    }

    public void newWith(Folder folder) {
        manager.driver().findElement(By.xpath("//*[@id=\"ttbfolder\"]")).click();
        manager.driver().findElement(By.name("new-folder-name")).sendKeys(folder.getName());
        manager.driver().findElement(By.name("new-folder-name")).sendKeys(Keys.ENTER);
    }

    public Folder lastCreatedFolder() {
        manager.driver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String content = manager.driver().findElement(By.cssSelector(".folderlist > li:nth-child(1) > a:nth-child(2)")).getText();
        return new Folder(content);
    }
}

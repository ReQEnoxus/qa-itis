package helpers;

import dto.Folder;
import manager.ApplicationManager;
import org.openqa.selenium.By;

public class FolderHelper extends HelperBase {
    public FolderHelper(ApplicationManager manager) {
        super(manager);
    }

    public void newWith(Folder folder) {
        manager.driver().findElement(By.xpath("//*[@id=\"ttbfolder\"]")).click();
        manager.driver().findElement(By.name("new-folder-name")).sendKeys(folder.getName());
        manager.driver().findElement(By.id("todos")).click();
    }
}

package helpers;

import dto.Note;
import manager.ApplicationManager;
import org.openqa.selenium.By;

public class NoteHelper extends HelperBase {
    public NoteHelper(ApplicationManager manager) {
        super(manager);
    }

    public void newWith(Note note) {
        manager.driver().findElement(By.linkText("My notes")).click();
        manager.driver().findElement(By.cssSelector(".outline img")).click();
        manager.driver().findElement(By.name("title")).sendKeys(note.getContent());
        manager.driver().findElement(By.id("todos")).click();
    }
}

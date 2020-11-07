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

    public Note lastCreatedNote() {
        String content = manager.driver().findElement(By.name("title")).getAttribute("value");
        return new Note(content);
    }

    public void renameLastNoteWith(String name) {
        manager.driver().findElement(By.linkText("My notes")).click();
        manager.driver().findElement(By.cssSelector("li:nth-child(1) > .todo-href")).click();
        manager.driver().findElement(By.name("title")).clear();
        manager.driver().findElement(By.name("title")).sendKeys(name);
    }
}

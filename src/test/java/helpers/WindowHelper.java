package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.Dimension;

public class WindowHelper extends HelperBase {
    public WindowHelper(ApplicationManager manager) {
        super(manager);
    }

    public void resize(int width, int height) {
        manager.driver().manage().window().setSize(new Dimension(width, height));
    }
}

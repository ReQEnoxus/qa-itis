package base;

import manager.ApplicationManager;
import org.junit.Before;
import org.junit.Test;

public abstract class TestBase {

    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }

    @Test
    public abstract void testCase();
}

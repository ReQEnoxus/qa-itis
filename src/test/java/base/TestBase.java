package base;

import manager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class TestBase {

    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager();
    }

    @After
    public void tearDown() {
        app.terminate();
    }

    @Test
    public abstract void testCase();
}

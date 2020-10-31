package helpers;

import manager.ApplicationManager;

public abstract class HelperBase {
    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }
}

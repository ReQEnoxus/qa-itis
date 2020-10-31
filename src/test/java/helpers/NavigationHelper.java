package helpers;

import manager.ApplicationManager;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
        baseUrl = manager.baseUrl();
    }

    public void navigateTo(String pathComponents) {
        manager.driver().get(baseUrl + pathComponents);
    }
}

package exercise1;
//Use Case 3: Singleton Pattern (Creational)
class SettingsManager {
    private static SettingsManager instance;
    private String appTheme;

    private SettingsManager() {
        appTheme = "Light"; // Default theme
    }

    public static synchronized SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    public String getAppTheme() {
        return appTheme;
    }

    public void setAppTheme(String appTheme) {
        this.appTheme = appTheme;
    }
}

// Usage
public class SingletonPatternExample {
    public static void main(String[] args) {
        SettingsManager settings1 = SettingsManager.getInstance();
        SettingsManager settings2 = SettingsManager.getInstance();

        System.out.println("Initial theme: " + settings1.getAppTheme());
        settings2.setAppTheme("Dark");
        System.out.println("Updated theme from settings1: " + settings1.getAppTheme());
    }
}

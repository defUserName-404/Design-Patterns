import factories.GuiFactory;
import factories.LinuxFactory;
import factories.MacOsFactory;
import factories.WindowsFactory;

/**
 * Demo class. Everything comes together here.
 */
public class AbstractFactoryDemo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else if (osName.contains("linux")) {
            factory = new LinuxFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
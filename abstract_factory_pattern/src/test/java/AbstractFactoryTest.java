import buttons.Button;
import buttons.LinuxButton;
import buttons.MacOsButton;
import buttons.WindowsButton;
import checkboxes.Checkbox;
import checkboxes.LinuxCheckbox;
import checkboxes.MacOsCheckbox;
import checkboxes.WindowsCheckbox;
import factories.GuiFactory;
import factories.LinuxFactory;
import factories.MacOsFactory;
import factories.WindowsFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AbstractFactoryTest {

    @Test
    void testWindowsFactory() {
        GuiFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        assertInstanceOf(WindowsButton.class, button);
        assertInstanceOf(WindowsCheckbox.class, checkbox);
    }

    @Test
    void testMacOsFactory() {
        GuiFactory factory = new MacOsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        assertInstanceOf(MacOsButton.class, button);
        assertInstanceOf(MacOsCheckbox.class, checkbox);
    }

    @Test
    void testLinuxFactory() {
        GuiFactory factory = new LinuxFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        assertInstanceOf(LinuxButton.class, button);
        assertInstanceOf(LinuxCheckbox.class, checkbox);
    }

    @Test
    void testApplicationWithWindowsFactory() {
        GuiFactory factory = new WindowsFactory();
        Application app = new Application(factory);
        app.paint();
    }

    @Test
    void testApplicationWithMacOsFactory() {
        GuiFactory factory = new MacOsFactory();
        Application app = new Application(factory);
        app.paint();
    }

    @Test
    void testApplicationWithLinuxFactory() {
        GuiFactory factory = new LinuxFactory();
        Application app = new Application(factory);
        app.paint();
    }
}

import buttons.Button;
import buttons.HtmlButton;
import buttons.LinuxButton;
import buttons.WindowsButton;
import factory.Dialog;
import factory.HtmlDialog;
import factory.LinuxDialog;
import factory.WindowsDialog;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class FactoryPatternTest {

    @Test
    public void testWindowsDialogCreatesWindowsButton() {
        Dialog dialog = new WindowsDialog();
        Button button = dialog.createButton();
        assertInstanceOf(WindowsButton.class, button, "WindowsDialog should create WindowsButton");
    }

    @Test
    public void testHtmlDialogCreatesHtmlButton() {
        Dialog dialog = new HtmlDialog();
        Button button = dialog.createButton();
        assertInstanceOf(HtmlButton.class, button, "HtmlDialog should create HtmlButton");
    }

    @Test
    public void testLinuxDialogCreatesLinuxButton() {
        Dialog dialog = new LinuxDialog();
        Button button = dialog.createButton();
        assertInstanceOf(LinuxButton.class, button, "LinuxDialog should create LinuxButton");
    }
}

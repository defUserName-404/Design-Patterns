import buttons.Button;
import checkboxes.Checkbox;
import factories.GuiFactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GuiFactory guiFactory) {
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

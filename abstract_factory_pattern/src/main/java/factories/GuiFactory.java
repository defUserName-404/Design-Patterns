package factories;

import buttons.Button;
import checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GuiFactory {
    Button createButton();

    Checkbox createCheckbox();
}

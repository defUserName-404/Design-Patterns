package org.defusername.creational.factory_pattern.factory;

import org.defusername.creational.factory_pattern.buttons.Button;
import org.defusername.creational.factory_pattern.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

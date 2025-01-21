package org.defusername.creational.factory_pattern.factory;

import org.defusername.creational.factory_pattern.buttons.Button;
import org.defusername.creational.factory_pattern.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
package org.defusername.creational.factory_pattern.factory;

import org.defusername.creational.factory_pattern.buttons.Button;
import org.defusername.creational.factory_pattern.buttons.LinuxButton;

public class LinuxDialog extends Dialog {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
}

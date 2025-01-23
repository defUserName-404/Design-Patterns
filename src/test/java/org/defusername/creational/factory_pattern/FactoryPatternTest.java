package org.defusername.creational.factory_pattern;

import org.defusername.creational.factory_pattern.buttons.Button;
import org.defusername.creational.factory_pattern.buttons.HtmlButton;
import org.defusername.creational.factory_pattern.buttons.LinuxButton;
import org.defusername.creational.factory_pattern.buttons.WindowsButton;
import org.defusername.creational.factory_pattern.factory.Dialog;
import org.defusername.creational.factory_pattern.factory.HtmlDialog;
import org.defusername.creational.factory_pattern.factory.LinuxDialog;
import org.defusername.creational.factory_pattern.factory.WindowsDialog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FactoryPatternTest {

    @Test
    void testWindowsDialogCreatesWindowsButton() {
        Dialog dialog = new WindowsDialog();
        Button button = dialog.createButton();
        assertInstanceOf(WindowsButton.class, button, "WindowsDialog should create WindowsButton");
    }

    @Test
    void testHtmlDialogCreatesHtmlButton() {
        Dialog dialog = new HtmlDialog();
        Button button = dialog.createButton();
        assertInstanceOf(HtmlButton.class, button, "HtmlDialog should create HtmlButton");
    }

    @Test
    void testLinuxDialogCreatesLinuxButton() {
        Dialog dialog = new LinuxDialog();
        Button button = dialog.createButton();
        assertInstanceOf(LinuxButton.class, button, "LinuxDialog should create LinuxButton");
    }
}

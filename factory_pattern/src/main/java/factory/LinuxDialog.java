package factory;

import buttons.Button;
import buttons.LinuxButton;

public class LinuxDialog extends Dialog {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
}

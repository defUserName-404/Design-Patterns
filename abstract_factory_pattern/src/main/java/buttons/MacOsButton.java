package buttons;

/**
 * All products families have the same varieties (MacOS/Windows/Linux).
 * This is a MacOS variant of a button.
 */
public class MacOsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOsButton.");
    }
}

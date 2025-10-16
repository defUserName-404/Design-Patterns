package checkboxes;

/**
 * All products families have the same varieties (MacOS/Windows/Linux).
 * This is a variant of a checkbox.
 */
public class MacOsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created MacOsCheckbox.");
    }
}
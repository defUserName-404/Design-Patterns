package buttons;

/**
 * All products families have the same varieties (MacOS/Windows/Linux).
 * This is another variant of a button.
 */
public class LinuxButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created LinuxButton.");
    }
}
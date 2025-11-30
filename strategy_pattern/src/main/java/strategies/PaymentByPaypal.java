package strategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PaymentByPaypal implements PaymentStrategy {
    private static final Map<String, String> DATABASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATABASE.put("amanda", "amanda@email.com");
        DATABASE.put("john doe", "john.doe@email.com");
    }

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (!signedIn) return false;
        System.out.println("Paid " + paymentAmount + " using PayPal");
        return true;
    }

    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter your email");
            email = READER.readLine();
            System.out.println("Enter your password");
            password = READER.readLine();
            verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    private boolean verify() {
        setSignedIn(email.equals(DATABASE.get(password)));
        return signedIn;
    }
}

package strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PaymentByCreditCard implements PaymentStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (!cardIsPresent()) return false;
        System.out.println("Paid " + paymentAmount + " using credit card");
        return true;

    }

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            String number = READER.readLine();
            System.out.println();
            String date = READER.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}

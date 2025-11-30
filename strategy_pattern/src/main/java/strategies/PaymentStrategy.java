package strategies;

/**
 * Common interface for all strategies.
 */
public interface PaymentStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}

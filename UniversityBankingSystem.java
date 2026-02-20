import java.util.ArrayList;
import java.util.List;

/* Interface for all payment methods */
interface PaymentMethod {
    void process(double amount);
}

/* Bank Payment */
class BankPayment implements PaymentMethod {
    @Override
    public void process(double amount) {
        System.out.println("Bank Payment Processed: UGX " + amount);
        System.out.println("Bank confirmation verified.");
        System.out.println();
    }
}

/* Mobile Money Payment */
class MobileMoneyPayment implements PaymentMethod {
    @Override
    public void process(double amount) {
        System.out.println("Mobile Money Payment Processed: UGX " + amount);
        System.out.println("Transaction ID verified.");
        System.out.println();
    }
}

/* Card Payment */
class CardPayment implements PaymentMethod {
    @Override
    public void process(double amount) {
        System.out.println("Card Payment Processed: UGX " + amount);
        System.out.println("Card authorization approved.");
        System.out.println();
    }
}

/* Cheque Payment */
class ChequePayment implements PaymentMethod {
    @Override
    public void process(double amount) {
        System.out.println("Cheque Payment Processed: UGX " + amount);
        System.out.println("Cheque clearance days applied.");
        System.out.println();
    }
}

/* Cash Payment */
class CashPayment implements PaymentMethod {
    @Override
    public void process(double amount) {
        System.out.println("Cash Payment Processed: UGX " + amount);
        System.out.println();
    }
}

/* Main Payment Class using Composition */
class Payment {

    private final List<PaymentMethod> methods = new ArrayList<>();
    private final List<Double> amounts = new ArrayList<>();

    public void addPayment(PaymentMethod method, double amount) {
        methods.add(method);
        amounts.add(amount);
    }

    public void processPayments() {
        double total = 0;

        for (int i = 0; i < methods.size(); i++) {
            methods.get(i).process(amounts.get(i));
            total += amounts.get(i);
        }

        System.out.println("=================================");
        System.out.println("CONSOLIDATED RECEIPT GENERATED");
        System.out.println("Total Paid: UGX " + total);
        System.out.println("=================================");
    }
}

/* Main Class */
public class PaymentSystem {

    public static void main(String[] args) {

        // Example: UGX 120,000 split 40% Bank + 60% Mobile Money
        double totalAmount = 120000;

        double bankAmount = totalAmount * 0.40;      // 48,000
        double mobileAmount = totalAmount * 0.60;    // 72,000

        Payment payment = new Payment();

        payment.addPayment(new BankPayment(), bankAmount);
        payment.addPayment(new MobileMoneyPayment(), mobileAmount);

        payment.processPayments();
    }
}

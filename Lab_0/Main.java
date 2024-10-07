package Lab_0;

public class Main {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        Payment paypalPayment = new PayPalPayment();

        PaymentProcessor processor1 = new PaymentProcessor(creditCardPayment);
        processor1.processPayment(100.0);

        PaymentProcessor processor2 = new PaymentProcessor(paypalPayment);
        processor2.processPayment(150.0);
    }
}
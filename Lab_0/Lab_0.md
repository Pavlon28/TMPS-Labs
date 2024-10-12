# Payment System

This project is a simple example of how to manage different types of payments in Java using two of the **SOLID** principles: **Single Responsibility Principle** and **Open/Closed Principle**.

### SOLID Principles Used

**Single Responsibility Principle (SRP):**
Each class has only one job. The CreditCardPayment class only handles credit card payments, and the PayPalPayment class only handles PayPal payments. The PaymentProcessor class just manages the payment process.

#### Code example:

```java
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
```

**Open/Closed Principle (OCP):**
The system can be easily extended with new payment types without changing the existing code. For example, if you want to add a new method like BankTransferPayment, you can create a new class without touching the PaymentProcessor or other payment classes.

#### Code example:

```java
public interface Payment {
    void pay(double amount);
}


public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
    }
}


public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}
```

### Conclusion:

This project is a simple and effective demonstration of applying SOLID principles to a payment system. By using the Single Responsibility Principle each class has a clear and focused job, making the code easier to maintain and understand. The Open/Closed Principle allows the system to be extended with new payment methods without changing the existing code, ensuring flexibility and reducing the risk of errors.
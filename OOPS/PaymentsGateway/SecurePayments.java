package OOPS.PaymentsGateway;

interface Payment {
    void payment(double amount);
}

interface Refunds {
    void refundPayment(String transactionId);
}

interface PartialCapture {
    void capturePartialPayment(String transactionId, double amount);
}

interface AsianRegion {
    void asianRegion();
}

interface EuropeanRegion {
    void europeanRegion();
}

class FraudCheck implements Payment, AsianRegion, EuropeanRegion {
    @Override
    public void payment(double amount) {
        System.out.println("Processing Fraud Check payment of $" + amount);
    }

    @Override
    public void asianRegion() {
        System.out.println("Payment is from Asian Region");
    }

    @Override
    public void europeanRegion() {
        System.out.println("Payment is from European Region");
    }
}

class Stripe implements Payment, Refunds, PartialCapture {
    @Override
    public void payment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }

    @Override
    public void refundPayment(String transactionId) {
        System.out.println("Refunding Stripe payment with transaction ID: " + transactionId);
    }

    @Override
    public void capturePartialPayment(String transactionId, double amount) {
        System.out.println("Capturing partial Stripe payment of $" + amount + " for transaction ID: " + transactionId);
    }
}

class PayPal implements Payment, Refunds {
    @Override
    public void payment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @Override
    public void refundPayment(String transactionId) {
        System.out.println("Refunding PayPal payment with transaction ID: " + transactionId);
    }
}

class StoreCreditCard implements Payment {
    @Override
    public void payment(double amount) {
        System.out.println("Processing Store Credit Card payment of $" + amount);
    }
}

interface PaymentFailure {
    void paymentFailed();

}

interface PaymentSuccessfull{
    void paymentSuccessfull();

}

class Idempotent implements Payment, PaymentFailure, PaymentSuccessfull{
    @Override
    public void payment(double amount) {
        System.out.println("Processing Idempotent payment of $" + amount);
    }
    @Override
    public void paymentSuccessfull(){
        System.out.println("Payment done Successfully");
    }
    @Override
    public void paymentFailed(){
        System.out.println("Payment has been Failed");
    }
}

class Non_Idempotent implements Payment, PaymentFailure, PaymentSuccessfull{
    @Override
    public void payment(double amount) {
        System.out.println("Processing Non-Idempotent payment of $" + amount);
    }
    @Override
    public void paymentSuccessfull(){
        System.out.println("Payment done Successfully");
    }
    @Override
    public void paymentFailed(){
        System.out.println("Payment has been Failed");
    }
}

class SecurePayments {
    public static void main(String[] args) {
        Payment[] payments = {
            new Stripe(),
            new PayPal(),
            new StoreCreditCard(),
            new Idempotent(),
            new Non_Idempotent(),
            new FraudCheck()
        };
        for (Payment payment : payments) {
            payment.payment(100.0);
            
            if (payment instanceof Refunds refundablePayment) {
                refundablePayment.refundPayment("TXN12345");
            }
            if (payment instanceof PartialCapture partialCapturePayment) {
                partialCapturePayment.capturePartialPayment("TXN12345", 50.0);
            }
            if (payment instanceof StoreCreditCard storeCreditCardPayment) {
                System.out.println("Store Credit Card does not support refunds or partial captures.");
            }
            if (payment instanceof Stripe stripePayment) {
                System.out.println("Stripe supports full payments, refunds, and partial captures.");
            }
            if (payment instanceof PayPal payPalPayment) {
                System.out.println("PayPal supports full payments and refunds, but not partial captures.");
            }
            if (payment instanceof FraudCheck fraudCheckPayment) {
                System.out.println("Fraud Check is being performed.");
            }
            if (payment instanceof StoreCreditCard storeCreditCardPayment) {
                System.out.println("Store Credit Card supports only full payments.");
            }   
            if (payment instanceof Refunds refundablePayment) {
                System.out.println("This payment method supports refunds.");
            } else {
                System.out.println("This payment method does not support refunds.");
            }
            if (payment instanceof Idempotent idempotent) {
                System.out.println("Payment Should not be retried");
            }
            if (payment instanceof Non_Idempotent non_Idempotent){
                System.out.println("Payment Should be retried");
            }
        }
    }
}

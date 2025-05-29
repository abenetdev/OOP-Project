
public class Payment { private static int idCounter = 1; private String paymentID; private double amount; private Date paymentDate; private String paymentMethod;

public Payment(double amount, Date paymentDate, String paymentMethod) {
    this.paymentID = "PAY" + idCounter++;
    this.amount = amount;
    this.paymentDate = paymentDate;
    this.paymentMethod = paymentMethod;
}

public String getPaymentID() {
    return paymentID;
}

public double getAmount() {
    return amount;
}

public Date getPaymentDate() {
    return paymentDate;
}

public String getPaymentMethod() {
    return paymentMethod;
}

public boolean processPayment() {
    System.out.println("Processing payment: $" + amount);
    return true;
}

}




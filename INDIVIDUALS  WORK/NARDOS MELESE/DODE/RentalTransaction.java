

public RentalTransaction(double totalCost) {
    this.transactionID = "TRX" + idCounter++;
    this.totalCost = totalCost;
}

public String getTransactionID() {
    return transactionID;
}

public double getTotalCost() {
    return totalCost;
}

public String generateInvoice() {
    return "Invoice ID: " + transactionID + "\nTotal: $" + totalCost;
}

public void finalizeTransaction() {
    System.out.println("Transaction " + transactionID + " finalized.");
}

}


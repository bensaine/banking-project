//package banking;
public class Transaction implements ITransaction {
    public enum TransactionType {WITHDRAWAL, DEPOSIT}

    private TransactionType type;
    private double amount;
    
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    public TransactionType getTransactionType() {
        return this.type;
    }
    
    public void setTransactionType(TransactionType newType) {
        this.type = newType;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }

    @Override
    public String toString() {
        return this.type+" of $"+this.amount;
    }
}
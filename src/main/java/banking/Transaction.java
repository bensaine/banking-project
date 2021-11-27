/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Transaction implements ITransaction {
    public static enum TransactionType {WITHDRAWAL, DEPOSIT};
    private TransactionType type;
    private double amount;
    
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return this.type+" of $"+this.amount;
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
}

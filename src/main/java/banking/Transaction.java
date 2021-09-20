/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

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
        return type+" of $"+amount;
    }
}

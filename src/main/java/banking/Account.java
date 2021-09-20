/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import banking.Transaction.TransactionType;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Account implements IAccount {
    
    private int accountNumber;
    private double balance;
    private Client owner;
    ArrayList<Transaction> transactionList = new ArrayList<>();

    public Account(int accountNumber, Client owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double deposit(double d) {
        this.balance += d;
        Transaction newDeposit = new Transaction(TransactionType.DEPOSIT, d);
        transactionList.add(newDeposit);
        return this.balance;
    }

    public void displayAllTransactions() {
        System.out.println("Transactions for Account #"+accountNumber+":");
        transactionList.forEach((transaction) -> {System.out.println(transaction.toString());});
    }

    public ArrayList<Transaction> getTransactions() {
        return transactionList;
    }

    public double withdrawal(double w) {
        this.balance -= w;
        Transaction newWithdrawal = new Transaction(TransactionType.WITHDRAWAL, w);
        transactionList.add(newWithdrawal);
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account #"+accountNumber+" with balance of $"+balance;
    }

}

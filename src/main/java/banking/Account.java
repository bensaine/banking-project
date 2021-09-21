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
    
    protected int accountNumber;
    protected double balance;
    protected Client owner;
    protected static int counter = 0;
    protected ArrayList<Transaction> transactionList = new ArrayList<>();

    public Account(int accountNumber, Client owner) {
        Account.counter++;
        this.accountNumber = Account.counter;
        this.owner = owner;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double deposit(double d) {
        this.balance += d;
        Transaction newDeposit = new Transaction(TransactionType.DEPOSIT, d);
        this.transactionList.add(newDeposit);
        return this.balance;
    }

    public void displayAllTransactions() {
        System.out.println("Transactions for Account #"+this.accountNumber+":");
        //possible future solution: this.transactionList.forEach((transaction) -> {System.out.println(transaction.toString());});
        System.out.println(this.transactionList);
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactionList;
    }

    public double withdrawal(double w) {
        this.balance -= w;
        Transaction newWithdrawal = new Transaction(TransactionType.WITHDRAWAL, w);
        this.transactionList.add(newWithdrawal);
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account #"+this.accountNumber+" with balance of $"+this.balance;
    }

}

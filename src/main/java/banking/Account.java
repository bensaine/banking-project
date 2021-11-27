/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Account implements IAccount {
    public enum AccountType {CHECKING, SAVINGS}

    protected int accountNumber;
    protected double balance;
    protected Client owner;
    protected static int counter = 0;
    protected AccountType type;
    protected ArrayList<Transaction> transactionList = new ArrayList<>();

    public Account(AccountType type) {
        Account.counter++;
        this.accountNumber = Account.counter;
        this.type = type;
        this.balance = 0;
    }

    public Account(Client owner, AccountType type) {
        Account.counter++;
        this.accountNumber = Account.counter;
        this.owner = owner;
        this.type = type;
        this.balance = 0;
    }

    public double deposit(double d) {
        this.balance += d;
        Transaction newDeposit = new Transaction(Transaction.TransactionType.DEPOSIT, d);
        this.transactionList.add(newDeposit);
        return this.balance;
    }

    public void displayAllTransactions() {
        transactionList.forEach(System.out::println);
    }

    public double withdrawal(double w) {
        this.balance -= w;
        Transaction newWithdrawal = new Transaction(Transaction.TransactionType.WITHDRAWAL, w);
        this.transactionList.add(newWithdrawal);
        return this.balance;
    }

    @Override
    public String toString() {
        return this.type+"("+this.accountNumber+") $"+this.balance;
    }
    
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    
    public Client getOwner() {
        return this.owner;
    }
    
    public void setOwner(Client newOwner) {
        this.owner = newOwner;
    }
    
    public int getAccountCount() {
        return Account.counter;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return this.transactionList;
    }
    
    public void setTransactions(ArrayList<Transaction> newTransactionList) {
        this.transactionList = newTransactionList;
    }
}

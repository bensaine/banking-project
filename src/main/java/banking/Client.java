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
public class Client implements IClient {
    
    private int id;
    private String firstName;
    private String lastName;
    private static int counter = 0;
    private ArrayList<Account> accountList = new ArrayList<>();
    
    public Client(String firstName, String lastName) {
        Client.counter++;
        this.id = Client.counter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(Account newAccount) {
        newAccount.setOwner(this);
        this.accountList.add(newAccount);
    }

    public void displayAccounts() {
        accountList.forEach(System.out::println);
    }

    public Account getAccount(int accountNumber) {
        return this.accountList.stream().filter(account -> account.getAccountNumber() == (accountNumber)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "("+this.id+") "+this.lastName+", "+this.firstName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int newId) {
        this.id = newId;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    
    public int getClientCount() {
        return Client.counter;
    }
    
    public ArrayList<Account> getAccounts() {
        return this.accountList;
    }
    
    public void setAccounts(ArrayList<Account> newAccountList) {
        this.accountList = newAccountList;
    }
}

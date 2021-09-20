/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Client implements IClient {
    
    private int id;
    private String firstName;
    private String lastName;
    private static int counter;
    ArrayList<Account> accountList = new ArrayList<>();

    public int getId() {
        return id;
    }

    @Override
    public void addAccount(Account newAccount) {
        accountList.add(newAccount);
    }

    @Override
    public void displayAccounts() {
        System.out.println("Accounts for Client #"+id+":");
        accountList.forEach((account) -> {System.out.println(account.toString());}); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //todo check
    public Account getAccount(int accountNumber) {
        return accountList.stream().filter(account -> account.getAccountNumber() == (accountNumber)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Client #"+id+": "+firstName+" "+lastName;
    }
    
}

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
public class Banking {
    public static void main(String[] args) {
        Bank bank = new Bank("73636", "290 Domingo St.");
        bankActions(bank);
    }

    private static void bankActions(Bank bank) {
        UserInputManager userInputManager = new UserInputManager();
        int clientId, accountId = 0;
        double amount = 0.00;
        Client client = null;
        Account account = null;
        Transaction transaction = null;
        System.out.println("Welcome to Bank #"+bank.getBankNumber()+"!");
        switch (userInputManager.retrieveUserOption()) {
            case 1 -> {
                client = userInputManager.retrieveClientInfo();
                if (client == null) {
                    System.err.println("An error occurred. Invalid client.");
                    break;
                }
                bank.addClient(client);
                System.out.println("Client created successfully: " + client);
            }
            case 2 -> {
                clientId = userInputManager.retrieveClientId();
                client = bank.getClient(clientId);
                if (client == null) {
                    System.err.println("An error occurred. Invalid client ID.");
                    break;
                }
                account = userInputManager.retrieveAccountType();
                if (account == null) {
                    System.err.println("An error occurred. Invalid account type.");
                    break;
                }
                account.setOwner(client);
                client.addAccount(account);
                System.out.println("Account created successfully: " + account);
            }
            case 3 -> {
                account = getAccountSequence(bank, userInputManager);
                if (account == null) break;
                amount = userInputManager.retrieveTransactionAmount();
                if (amount <= 0) {
                    System.err.println("An error occurred. Invalid amount.");
                    break;
                }
                account.deposit(amount);
                System.out.println("Deposit successful: " + account);
            }
            case 4 -> {
                account = getAccountSequence(bank, userInputManager);
                if (account == null) break;
                amount = userInputManager.retrieveTransactionAmount();
                if (amount <= 0) {
                    System.err.println("An error occurred. Invalid amount.");
                    break;
                }
                account.withdrawal(amount);
                System.out.println("Withdrawal successful: " + account);
            }
            case 5 -> {
                account = getAccountSequence(bank, userInputManager);
                if (account == null) break;
                account.displayAllTransactions();
                System.out.println(account);
            }
            case 6 -> {
                clientId = userInputManager.retrieveClientId();
                client = bank.getClient(clientId);
                if (client == null) {
                    System.err.println("An error occurred. Invalid client ID.");
                    break;
                }
                System.out.println("List of current clients:");
                bank.displayClientList();
            }
            case 7 -> {
                clientId = userInputManager.retrieveClientId();
                client = bank.getClient(clientId);
                if (client == null) {
                    System.err.println("An error occurred. Invalid client ID.");
                    break;
                }
                System.out.println("Accounts for " + client);
                bank.displayClientAccounts(clientId);
            }
            default -> System.err.println("An error occurred. A1ction does not exist.");
        }
        if (userInputManager.retrieveExitAction() != 2) {
            bankActions(bank);
        }
        System.out.println("Exiting Bank #"+bank.getBankNumber()+"... Have a nice day!");


    }

    private static Account getAccountSequence(Bank bank, UserInputManager userInputManager) {
        int clientId;
        Client client;
        int accountId;
        Account account;
        clientId = userInputManager.retrieveClientId();
        client = bank.getClient(clientId);
        if (client == null) {
            System.err.println("An error occurred. Invalid client ID.");
            return null;
        }
        accountId = userInputManager.retrieveAccountNumber();
        account = client.getAccount(accountId);
        if (account == null) {
            System.err.println("An error occurred. Invalid account number.");
            return null;
        }
        return account;
    }

    private void getAccountSequence() {

    }

    private void createAccount() {

    }

    private void makeWithdrawal() {

    }

    private void makeDeposit() {

    }


}

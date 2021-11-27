public class Banking {
    private static UserInputManager uIM;

    public static void main(String[] args) {
        uIM = new UserInputManager();
        Bank bank = new Bank("73636", "290 Domingo St.");
        bankActions(bank);
    }

    private static void bankActions(Bank bank) {
        System.out.println("\u001B[31;40m+-------------------------+\n" +
                "| Welcome to Bank #"+bank.getBankNumber()+"! |\n" +
                "+-------------------------+\n");
        switch (uIM.retrieveUserOption()) {
            case 1 -> createClientSequence(bank);
            case 2 -> createAccountSequence(bank);
            case 3 -> createTransactionSequence(bank, Transaction.TransactionType.DEPOSIT);
            case 4 -> createTransactionSequence(bank, Transaction.TransactionType.WITHDRAWAL);
            case 5 -> listTransactionsSequence(bank);
            case 6 -> listClientsSequence(bank);
            case 7 -> listAccountsSequence(bank);
            default -> System.err.println("An error occurred. Action does not exist.");
        }
        if (uIM.retrieveExitAction() != 2) {
            bankActions(bank);
        } else {
            System.out.println("\u001B[31mExiting Bank #"+bank.getBankNumber()+"... \u001B[33mHave a nice day!");
        }
    }

    private static void createClientSequence(Bank bank) {
        Client client = uIM.retrieveClientInfo();
        if (client == null) {
            System.err.println("An error occurred. Invalid client.");
            return;
        }
        bank.addClient(client);
        System.out.println("\u001B[35mClient created successfully: " + client);
    }

    private static void createAccountSequence(Bank bank) {
        Client client = getClientSequence(bank);
        if (client == null) return;
        Account account = uIM.retrieveAccountType();
        if (account == null) {
            System.err.println("An error occurred. Invalid account type.");
            return;
        }
        account.setOwner(client);
        client.addAccount(account);
        System.out.println("\u001B[35mAccount created successfully for "+client+": " + account);
    }

    private static void createTransactionSequence(Bank bank, Transaction.TransactionType type) {
        Client client = getClientSequence(bank);
        if (client == null) return;
        Account account = getAccountSequence(client);
        if (account == null) return;
        double amount = uIM.retrieveTransactionAmount();
        if (amount <= 0) {
            System.err.println("An error occurred. Invalid amount.");
            return;
        }
        if (type == Transaction.TransactionType.DEPOSIT) account.deposit(amount);
        else if (type == Transaction.TransactionType.WITHDRAWAL) account.withdrawal(amount);
        System.out.println("\u001B[35m"+type+" successful: " + account);
    }

    private static void listTransactionsSequence(Bank bank) {
        Client client = getClientSequence(bank);
        if (client == null) return;
        Account account = getAccountSequence(client);
        if (account == null) return;
        System.out.print("\u001B[35m");
        account.displayAllTransactions();
        System.out.print("\u001B[34m");
        System.out.println(account);
    }

    private static void listClientsSequence(Bank bank) {
        System.out.println("\u001B[35mList of current clients:\u001B[34m");
        bank.displayClientList();
    }

    private static void listAccountsSequence(Bank bank) {
        Client client = getClientSequence(bank);
        if (client == null) return;
        System.out.println("\u001B[35mAccounts for " + client + "\u001B[34m");
        bank.displayClientAccounts(client.getId());
    }

    private static Client getClientSequence(Bank bank) {
        int clientId = uIM.retrieveClientId();
        Client client = bank.getClient(clientId);
        if (client == null) System.err.println("An error occurred. Invalid client ID.");
        return client;
    }

    private static Account getAccountSequence(Client client) {
        int accountId = uIM.retrieveAccountNumber();
        Account account = client.getAccount(accountId);
        if (account == null) System.err.println("An error occurred. Invalid account number.");
        return account;
    }
}
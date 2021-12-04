//package banking;
public class Banking {
    public static void main(String[] args) {
        Bank bank = new Bank("734-36", "290 Domingo St.");
        System.out.println("\u001B[31m+--------------------------+\n" +
                "| Welcome to Bank #"+bank.getBankNumber()+"! |\n" +
                "+--------------------------+\n");
        bankActions(bank);
    }

    private static void bankActions(Bank bank) {
        UserInputManager uIM = new UserInputManager();
        switch (uIM.retrieveUserOption()) {
            case 1 -> createClientSequence(bank, uIM);
            case 2 -> createAccountSequence(bank, uIM);
            case 3 -> createTransactionSequence(bank, uIM, Transaction.TransactionType.DEPOSIT);
            case 4 -> createTransactionSequence(bank, uIM, Transaction.TransactionType.WITHDRAWAL);
            case 5 -> listTransactionsSequence(bank, uIM);
            case 6 -> listClientsSequence(bank);
            case 7 -> listAccountsSequence(bank, uIM);
            case 8 -> System.out.println("\u001B[31mExiting Bank #"+bank.getBankNumber()+"... \u001B[33mHave a nice day!");
            default -> bankActions(bank);
        }
    }

    private static void createClientSequence(Bank bank, UserInputManager uIM) {
        Client client = uIM.retrieveClientInfo();
        if (client == null) {
            System.err.println("An error occurred. Invalid client information.\nPlease try again.");
            createClientSequence(bank, uIM);
            return;
        }
        bank.addClient(client);
        System.out.println("\u001B[35mClient created successfully: " + client);
        bankActions(bank);
    }

    private static void createAccountSequence(Bank bank, UserInputManager uIM) {
        Client client = getClientSequence(bank, uIM);
        if (client == null) {
            System.err.println("An error occurred. Invalid client ID.\nPlease try again.");
            createAccountSequence(bank, uIM);
            return;
        }
        Account account = uIM.retrieveAccountType();
        if (account == null) {
            System.err.println("An error occurred. Invalid account type.\nPlease try again.");
            createAccountSequence(bank, uIM);
            return;
        }
        client.addAccount(account);
        System.out.println("\u001B[35mAccount created successfully for "+client+": " + account);
        bankActions(bank);
    }

    private static void createTransactionSequence(Bank bank, UserInputManager uIM, Transaction.TransactionType type) {
        Account account = getAccountSequence(bank, uIM);
        if (account == null) {
            System.err.println("An error occurred. Invalid account number or client ID.\nPlease try again.");
            createTransactionSequence(bank, uIM, type);
            return;
        }
        double amount = uIM.retrieveTransactionAmount();
        if (amount <= 0) {
            System.err.println("An error occurred. Invalid amount.\nPlease try again.");
            createTransactionSequence(bank, uIM, type);
            return;
        }
        if (type == Transaction.TransactionType.DEPOSIT) account.deposit(amount);
        else if (type == Transaction.TransactionType.WITHDRAWAL) account.withdrawal(amount);
        System.out.println("\u001B[35m"+type+" successful: " + account);
        bankActions(bank);
    }

    private static void listTransactionsSequence(Bank bank, UserInputManager uIM) {
        Account account = getAccountSequence(bank, uIM);
        if (account == null) {
            System.err.println("An error occurred. Invalid account number or client ID.\nPlease try again.");
            listTransactionsSequence(bank, uIM);
            return;
        }
        System.out.print("\u001B[35m");
        account.displayAllTransactions();
        System.out.print("\u001B[36m");
        System.out.println(account);
        bankActions(bank);
    }

    private static void listClientsSequence(Bank bank) {
        System.out.println("\u001B[35mList of current clients:\u001B[36m");
        bank.displayClientList();
        bankActions(bank);
    }

    private static void listAccountsSequence(Bank bank, UserInputManager uIM) {
        Client client = getClientSequence(bank, uIM);
        if (client == null) {
            System.err.println("An error occurred. Invalid client ID.\nPlease try again.");
            listAccountsSequence(bank, uIM);
            return;
        }
        System.out.println("\u001B[35mAccounts for " + client + "\u001B[36m");
        bank.displayClientAccounts(client.getId());
        bankActions(bank);
    }

    private static Client getClientSequence(Bank bank, UserInputManager uIM) {
        int clientId = uIM.retrieveClientId();
        return bank.getClient(clientId);
    }

    private static Account getAccountSequence(Bank bank, UserInputManager uIM) {
        int clientId = uIM.retrieveClientId();
        int accountId = uIM.retrieveAccountNumber();
        return bank.getClientAccount(clientId, accountId);
    }
}

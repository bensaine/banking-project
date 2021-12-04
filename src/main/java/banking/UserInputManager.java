//package banking;
import java.util.Scanner;

public class UserInputManager implements IUserInputManager {
    public UserInputManager() {
    }

    public int retrieveAccountNumber() {
        Scanner sc = new Scanner(System.in);
        int accountNum = -1;
        System.out.println("\u001B[36mPlease input the \u001B[31maccount number.\u001B[0m");
        if (sc.hasNextInt()) accountNum = sc.nextInt();
        return accountNum;
    }

    public Account retrieveAccountType() {
        Scanner sc = new Scanner(System.in);
        int type = -1;
        System.out.println("""
                \u001B[32mPlease input an \u001B[31maccount type.
                \u001B[35m①\u001B[36m Checking;
                \u001B[35m②\u001B[36m Savings.\u001B[0m""");
        if (sc.hasNextInt()) type = sc.nextInt();
        Account account = null;
        if (type == 1) account = new CheckingAccount();
        else if (type == 2) account = new SavingsAccount();
        return account;
    }

    public int retrieveClientId() {
        Scanner sc = new Scanner(System.in);
        int clientId = -1;
        System.out.println("\u001B[36mPlease enter the \u001B[31mclient ID.\u001B[0m");
        if (sc.hasNextInt()) clientId = sc.nextInt();
        return clientId;
    }

    public Client retrieveClientInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[36mPlease enter the client's \u001B[31mfirst name\u001B[36m.\u001B[0m");
        String firstName = sc.nextLine();
        if (firstName.isBlank()) return null;
        System.out.println("\u001B[36mPlease enter the client's \u001B[31mlast name\u001B[36m.\u001B[0m");
        String lastName = sc.nextLine();
        if (lastName.isBlank()) return null;
        return new Client(firstName, lastName);
    }

    public double retrieveTransactionAmount() {
        Scanner sc = new Scanner(System.in);
        double transactionAmount = 0;
        System.out.println("\u001B[36mPlease input the \u001B[31mtransaction amount.\u001B[0m");
        if (sc.hasNextDouble()) transactionAmount = sc.nextDouble();
        return transactionAmount;
    }

    public int retrieveUserOption() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        System.out.println("""
                                
                \u001B[32mHow can we help you today?
                \u001B[35m①\u001B[36m Add a new client;
                \u001B[35m②\u001B[36m Create a new account;
                \u001B[35m③\u001B[36m Make a deposit;
                \u001B[35m④\u001B[36m Make a withdrawal;
                \u001B[35m⑤\u001B[36m List account transactions;
                \u001B[35m⑥\u001B[36m List clients;
                \u001B[35m⑦\u001B[36m List client accounts;
                \u001B[35m⑧\u001B[36m Exit.\u001B[0m""");
        if (sc.hasNextInt()) option = sc.nextInt();
        return option;
    }
}
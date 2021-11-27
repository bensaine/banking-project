import java.util.Scanner;

public class UserInputManager implements IUserInputManager {

    public int retrieveAccountNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the account number.");
        return sc.nextInt();
    }

    public Account retrieveAccountType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                \u001B[32mPlease input an account type.
                \u001B[35m➊\u001B[34m Checking;
                \u001B[35m➋\u001B[34m Savings.""");
        int type = sc.nextInt();
        Account account = null;
        if (type == 1) account = new CheckingAccount();
        else if (type == 2) account = new SavingsAccount();
        return account;
    }

    public int retrieveClientId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the client ID.");
        return sc.nextInt();
    }

    public Client retrieveClientInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the client's \u001B[31mfirst name\u001B[34m.");
        String firstName = sc.nextLine();
        System.out.println("Please enter the client's \u001B[31mlast name\u001B[34m.");
        String lastName = sc.nextLine();
        return new Client(firstName, lastName);
    }

    public double retrieveTransactionAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the transaction amount.");
        return sc.nextDouble();
    }

    @Override
    public int retrieveUserOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                \u001B[32mHow can we help you today?
                \u001B[35m➊\u001B[34m Add a new client;
                \u001B[35m➋\u001B[34m Create a new account;
                \u001B[35m➌\u001B[34m Make a deposit;
                \u001B[35m➍\u001B[34m Make a withdrawal;
                \u001B[35m➎\u001B[34m List account transactions;
                \u001B[35m➏\u001B[34m List clients;
                \u001B[35m➐\u001B[34m List client accounts.""");
        return sc.nextInt();
    }

    public int retrieveExitAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                
                \u001B[32mWould you like to:
                \u001B[35m➊\u001B[34m Return to main menu;
                \u001B[35m➋\u001B[31m Exit.""");
        return sc.nextInt();
    }
}
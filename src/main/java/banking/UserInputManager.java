import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class UserInputManager implements IUserInputManager {

    public UserInputManager() {
    }

    @Override
    public int retrieveAccountNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the account number.");
        return sc.nextInt();
    }

    @Override
    public Account retrieveAccountType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Please input an account type.
                ➊ Checking;
                ➋ Savings.""");
        int type = sc.nextInt();
        Account account = null;
        if (type == 1) account = new CheckingAccount();
        else if (type == 2) account = new SavingsAccount();
        else System.err.println("An error occurred. Invalid account type.");
        return account;
    }

    @Override
    public int retrieveClientId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the client ID.");
        return sc.nextInt();
    }

    @Override
    public Client retrieveClientInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the client's first name.");
        String firstName = sc.nextLine();
        System.out.println("Please enter the client's last name.");
        String lastName = sc.nextLine();
        return new Client(firstName, lastName);
    }

    @Override
    public double retrieveTransactionAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the transaction amount.");
        return sc.nextDouble();
    }

    @Override
    public int retrieveUserOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                How can we help you today?
                ➊ Add a new client;
                ➋ Create a new account;
                ➌ Make a deposit;
                ➍ Make a withdrawal;
                ➎ List account transactions;
                ➏ List clients;
                ➐ List client accounts.""");
        return sc.nextInt();
    }

    public int retrieveExitAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Would you like to:
                ➊ Return to main menu;
                ➋ Exit.""");
        return sc.nextInt();
    }
}

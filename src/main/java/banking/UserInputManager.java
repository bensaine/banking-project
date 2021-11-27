

        import java.util.Scanner;

/**
 *
 * @author Administrator
 */
        public class UserInputManager implements IUserInputManager{

        public UserInputManager() {
        }

        @Override
        public int retrieveAccountNumber() {
        return 0;
        }

        @Override
        public Account retrieveAccountType() {
        return null;
        }

        @Override
        public int retrieveClientId() {
        System.out.println("Please Enter your ID");
        Scanner sc = new Scanner(System.in);
        int clientID = sc.nextInt();
        return clientID;
        }

        @Override
        public Client retrieveClientInfo() {
            System.out.println("Welcome to Big Dick's Bank");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your first Name");
            String firstName = sc.nextLine();
            System.out.println("Enter your first Name");
            String lastName = sc.nextLine();
            Client newclient = new Client(firstName, lastName);
            System.out.println("Greetings: "+ newclient);
            return newclient;
        }

        @Override
        public double retrieveTransactionAmount() {
        return 0.0;
        }

        @Override
        public int retrieveUserOption() {
        return 0;
        }

        }

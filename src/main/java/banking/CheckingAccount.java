//package banking;
public class CheckingAccount extends Account {
    public CheckingAccount() {
        super(AccountType.CHECKING);
    }

    public CheckingAccount(Client owner) {
        super(owner, AccountType.CHECKING);
    }
}
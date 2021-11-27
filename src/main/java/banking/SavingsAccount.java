public class SavingsAccount extends Account {
    public SavingsAccount() {
        super(AccountType.SAVINGS);
    }

    public SavingsAccount(Client owner) {
        super(owner, AccountType.SAVINGS);
    }
}
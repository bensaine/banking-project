/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class SavingsAccount extends Account {
    public SavingsAccount() {
        super(AccountType.SAVINGS);
    }

    public SavingsAccount(Client owner) {
        super(owner, AccountType.SAVINGS);
    }
}

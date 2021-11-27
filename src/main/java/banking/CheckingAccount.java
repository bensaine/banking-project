/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class CheckingAccount extends Account {
    public CheckingAccount() {
        super(AccountType.CHECKING);
    }

    public CheckingAccount(Client owner) {
        super(owner, AccountType.CHECKING);
    }
}
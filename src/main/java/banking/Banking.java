/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Banking {
    public static void main(String[] args) {
        Bank downtownBank = new Bank("73636", "290 Domingo St.");
        Client lol = new Client("potato", "muffin");
        downtownBank.addClient(lol);

        lol.addAccount(new CheckingAccount());
        downtownBank.displayClientAccounts(lol.getId());
    }
}

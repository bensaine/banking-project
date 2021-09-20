/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class Bank implements IBank {
    private String bankNumber;
    private String address;
    ArrayList<Client> clientList = new ArrayList<>();
    
    public Bank(String bankNumber, String address) {
        this.bankNumber = bankNumber;
        this.address = address;
    }

    public void addClient(Client newClient) {
        this.clientList.add(newClient);
    }

    public void displayClientAccounts(int clientId) {
        getClient(clientId).displayAccounts();
    }

    public void displayClientList() {
        System.out.println("Clients for Bank #"+bankNumber+":");
        clientList.forEach((client) -> {System.out.println(client.toString());});
    }

    public Client getClient(int id) {
        return clientList.stream().filter(client -> client.getId() == (id)).findFirst().orElse(null);
    }

    public Account getClientAccount(int clientId, int accountNumber) {
        return getClient(clientId).getAccount(accountNumber);
    }
}

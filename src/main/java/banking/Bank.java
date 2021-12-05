//package banking;
import java.util.ArrayList;

public class Bank implements IBank {
    private String bankNumber;
    private String address;
    private ArrayList<Client> clientList = new ArrayList<>();
    
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
        for(Client c: this.clientList) System.out.println(c);
    }

    public Client getClient(int id) {
        for(Client c: this.clientList) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public Account getClientAccount(int clientId, int accountNumber) {
        Account account = null;
        Client client = getClient(clientId);
        if (client != null) account = client.getAccount(accountNumber);
        return account;
    }
    
    public String getBankNumber() {
        return this.bankNumber;
    }
    
    public void setBankNumber(String newBankNumber) {
        this.bankNumber = newBankNumber;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    
    public ArrayList<Client> getClients() {
        return this.clientList;
    }
    
    public void setClients(ArrayList<Client> newClientList) {
        this.clientList = newClientList;
    }
}
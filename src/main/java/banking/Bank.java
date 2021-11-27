import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
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
        clientList.forEach(System.out::println);
    }

    public Client getClient(int id) {
        return this.clientList.stream().filter(client -> client.getId() == (id)).findFirst().orElse(null);
    }

    public Account getClientAccount(int clientId, int accountNumber) {
        return getClient(clientId).getAccount(accountNumber);
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
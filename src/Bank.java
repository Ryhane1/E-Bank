public class Bank {
    private Client client;
    private Account account;

    public Bank(Client client, Account account) {
        this.client = client;
        this.account = account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

public class Client extends Person{
    private int idClient;
    private Person person;

    public Client(String name, int idClient , int telefone) {
        super(name, telefone);
        this.idClient = idClient;
        this.person = person;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }




}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();
    static ArrayList<Bank> banks = new ArrayList<>();
    static ArrayList<Savings> savings = new ArrayList<>();
    static Client client = null ;
    static Account account = null;
    static Bank bank = null;
    static Savings saving = null;
    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);
        Account a1 = new Account(1 , 1000 , "Basique");
        Account a2 = new Account(2 , 2000 , "Basique");
        Account a3 = new Account(3 , 3000 , "Basique");
        Account a4 = new Account(4 , 4000 , "Basique");
        Client c1 = new Client("Ahmed" , 11 , 45678909);
        Client c2 = new Client("Rachid" , 22 , 45984506);
        Client c3 = new Client("Ryhane" , 33 , 45677653);
        Client c4 = new Client("Yassine" , 44 , 45672310);
        bank = new Bank(c1, a1);
        banks.add(bank);
        bank = new Bank(c2, a2);
        banks.add(bank);
        bank = new Bank(c3, a3);
        banks.add(bank);
        bank = new Bank(c4, a4);
        banks.add(bank);
        int choix =0 ;

            do {
                try {
                    System.out.println(" ");
                    System.out.println("Menu : ");
                    System.out.println("1. Creer un Compte .");
                    System.out.println("2. Consulter Le Solde .");
                    System.out.println("3. Deposer Le Solde .");
                    System.out.println("4. Retirer Le Solde . ");
                    System.out.println("5. Afficher Les Comptes . ");
                    System.out.println("6. Supprimer Un Compte . ");
                    System.out.println("7. Creer un Compte d'Epargne . ");
                    System.out.println("8. Afficher les Comptes d'Epargne . ");
                    System.out.println("9. Transfert du solde .");
                    System.out.println("10. Quitter ");
                    System.out.println("Entrer votre Choix : ");
                    choix = add.nextInt();

                    switch (choix) {
                        case 1 -> addAccount(add);
                        case 2 -> displaySold(add);
                        case 3 -> addSold(add);
                        case 4 -> withdrawSold(add);
                        case 5 -> displayAccounts();
                        case 6 -> deleteAccount(add);
                        case 7 -> savingAccount(add);
                        case 8 -> displaySavings();
                        case 9 -> transfertSold(add);
                        case 10 -> System.out.println("Au revoir !");
                        default -> System.out.println("Choix Invalid ! ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input Invalid ! ");
                    add.nextLine();
                }
            } while (choix != 10);
            add.close();

    }
    public static void addAccount(Scanner add ){
            System.out.println("Enter le Nom du Bénéficiaire : ");
            String nom = add.nextLine();
            add.nextLine();
            int idClient = new Random().nextInt(Integer.MAX_VALUE);
            System.out.println("Le ID du Client est Générer ! ");
//            System.out.println("Entre le ID du Client : ");
//            int idClient = add.nextInt();
            System.out.println("Entre le numero de Telephone : ");
            int telefone = add.nextInt();
            System.out.println("Client crée !!");
            client = new Client(nom, idClient, telefone);
            clients.add(client);

//            System.out.println("ID du compte est générer !! ");
//            int id = new Random().nextInt(Integer.MAX_VALUE);
//            System.out.println("Entre ID du compte : ");
//            int id = add.nextInt();
//            for (Bank b : banks){
//                if (id==b.getAccount().getId()){
//                    System.out.println("ID deja Existe !");
//                    System.out.println("Entre autre ID : ");
//                    id = add.nextInt();
//                    return;
//                }}





        boolean idExiste = true;
        int id =0 ;
        while (idExiste) {
            System.out.println("Entrez l'ID du compte : ");
            id = add.nextInt();
            idExiste = false;
            for (Bank b : banks) {
                if (id == b.getAccount().getId()) {
                    System.out.println("Erreur : l'ID " + id + " existe déjà !");
                    idExiste = true;
                    break;
                }
            }
        }
        System.out.println("ID validé.");



        System.out.println("Entre votre Solde Initial : ");
            float sold = add.nextFloat();
            System.out.println("Type de Compte : ");
            add.nextLine();
            String type = add.nextLine();
            account = new Account(id, sold, type);
            accounts.add(account);
            bank = new Bank(client, account);
            banks.add(bank);
    }
    public static void displaySold(Scanner add){
        System.out.println("Entre ID du compte : ");
        Integer id = add.nextInt();
        boolean isFound = false;
        for (int i =0 ; i < banks.size() ; i++){
            if (id.equals(banks.get(i).getAccount().getId())){
                float sold = banks.get(i).getAccount().getSold();
                System.out.println("Le Solde de votre Compte est  : "+ sold+" MAD");
                isFound = true;
                break;
            }
        }if (!isFound){
            System.out.println("Ce Compte n'existe Pas !!");
        }
    }
    public static void addSold(Scanner add){
        System.out.println("Entre ID du compte : ");
        int id = add.nextInt();
        boolean isFound = false;
        for (int i =0 ; i < banks.size() ; i++){
            if (id == banks.get(i).getAccount().getId()){
                float sold = banks.get(i).getAccount().getSold();
                System.out.println("Votre Sold initial  : "+ sold+" MAD");
                System.out.println("Entre le Solde du dépot  : ");
                float newsold = add.nextFloat();
                banks.get(i).getAccount().setSold(sold + newsold) ;
                System.out.println("Le Nouveau Solde  : "+ banks.get(i).getAccount().getSold()+" MAD");
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Ce Compte n'existe Pas !!");
        }
    }
    public static void withdrawSold(Scanner add){
        System.out.println("Entre ID du Compte : ");
        Integer id = add.nextInt();
        boolean isFound = false;
        for (Bank b : banks){
            if (id.equals(b.getAccount().getId())){
                float sold = b.getAccount().getSold();
                System.out.println("Votre Sold initial  : "+ sold+" MAD");
                System.out.println("Entre le Sold a Retirer  : ");
                float newsold = add.nextFloat();
                if (newsold <= sold){
                    b.getAccount().setSold(sold - newsold)  ;
                    System.out.println("Nouveau Sold  : "+ b.getAccount().getSold()+" MAD");
                }else {
                    System.out.println("Solde Insuffisant pour ce retrait !!");
                }
                isFound = true;
                break;
            }
        }if (!isFound){
            System.out.println("Ce Compte n'existe Pas !!");
        }

    }
    public static void displayAccounts() {
        for (int i = 0; i < banks.size(); i++) {
            int idClient = banks.get(i).getClient().getIdClient();
            int id = banks.get(i).getAccount().getId();
            float sold =banks.get(i).getAccount().getSold();
            String type = banks.get(i).getAccount().getType();
            System.out.println("Client ID : "+idClient+" , Numero du Compte : "+id+
                    " , Type : "+type+" , Solde : "+sold+" MAD");
        }
    }
    public static void deleteAccount(Scanner add){
        System.out.println("Entre Id du Compte : ");
        int id = add.nextInt();
        boolean isFound = false;
        for (int i = 0; i < banks.size(); i++){
            if (id == banks.get(i).getAccount().getId()){
                bank = banks.get(i);
                banks.remove(bank);
                System.out.println("Compte est Supprimer !!");
                isFound = true;
                break;
            }
        }if (!isFound){
            System.out.println("Ce Compte n'existe Pas !!");
        }
    }
    public static void savingAccount(Scanner add){
        System.out.println("Entre Id du Compte : ");
        int id = add.nextInt();
        boolean isFound = false ;
        for (int i = 0 ; i <banks.size(); i++){
            if (id == banks.get(i).getAccount().getId()){
                System.out.println("Entre le Montant d'Epargne : ");
                float savold = add.nextFloat();
                double savingSold = savold * 1.10 ;
                double interet = savold * 0.10;
                System.out.println("Compte a été Créer avec Succes !!");
                System.out.println("Montant d'Interet de 10% : "+interet+" MAD");
                System.out.println("Montant d'Epargne Aprés 10% d'Interet : "+savingSold+" MAD");
                int idSaving = banks.get(i).getAccount().getId();
                float sold = banks.get(i).getAccount().getSold();
                String type = "Savings";
                saving = new Savings(idSaving, sold, type ,savingSold);
                savings.add(saving);
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Ce Compte n'existe Pas !!");
        }
    }
    public static void displaySavings(){
        for (int i=0 ; i < savings.size(); i++){
            System.out.println("Compte Id : "+savings.get(i).getId()+
                    " , Sold du Compte initial : "+savings.get(i).getSold()+
                    " MAD , Montant d'Epargne : "+savings.get(i).getSavings()+" MAD");
        }
    }
    public static void transfertSold(Scanner add) {
        System.out.println("Entre le ID du Compte d'Expediteur : ");
        int id = add.nextInt();
        boolean isFound = false;
        for (Bank b : banks) {
            if (id == b.getAccount().getId()) {isFound = true;}
            }
        if (!isFound) {
            System.out.println("Le Compte Expéditeur n'existe Pas !!");
            return;
        }

        System.out.println("Entre le ID du Récépteur : ");
        int idR = add.nextInt();
        boolean isFoundR = false;
        add.nextLine();
        for (Bank r : banks) {
            if (idR == r.getAccount().getId()) { isFoundR = true;}
        }
        if (!isFoundR) {
            System.out.println("Le Compte Recepteur n'existe Pas !!");
            return;
        }

        for (Bank b : banks) {
            for (Bank r : banks) {
                if (id == b.getAccount().getId() && idR == r.getAccount().getId()) {
                    System.out.println("Entre Le solde a Transferer : ");
                    float transfrSold = add.nextFloat();
                    float sold = b.getAccount().getSold();
                    if (transfrSold <= sold) {
                        b.getAccount().setSold(sold - transfrSold);
                        float soldR = r.getAccount().getSold();
                        r.getAccount().setSold(soldR + transfrSold);
                        System.out.println("Votre Solde est Transferer !!");
                    } else {
                        System.out.println("Votre Solde est Insuffisant !!");
                    }
                }
            }
        }
    }
}
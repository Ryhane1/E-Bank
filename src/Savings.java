public class Savings extends Account {
    //    private Account account;
//    private Bank bank;
    private double savings;

    public Savings(int id, float sold, String type, double savings) {
        super(id, sold, type);
        this.savings = savings;
    }


    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }
}

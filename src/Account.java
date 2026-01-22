public class Account {
    private int id ;
    private float sold ;
    private String type ;

    public Account(int id, float sold, String type) {
        this.id = id;
        this.sold = sold;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSold() {
        return sold;
    }

    public void setSold(float sold) {
        this.sold = sold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

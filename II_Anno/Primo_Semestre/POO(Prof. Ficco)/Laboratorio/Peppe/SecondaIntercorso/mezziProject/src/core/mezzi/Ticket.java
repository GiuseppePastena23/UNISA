package core.mezzi;

public class Ticket {   
    
    private boolean isValid;
    private final int price;

    public Ticket(boolean isValid, int price){
        this.isValid = isValid;
        this.price = price;
    }

}

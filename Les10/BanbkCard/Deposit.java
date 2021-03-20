package BanbkCard;

public class Deposit extends Card {

    @Override
    public double getBalance() {
        return super.getBalance()*2;
    }
}

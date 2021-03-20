package BanbkCard;

public class CreditCard extends Credit {

    public CreditCard(String bankName, String cardNumber, String holderName, String validity, double balance) {
        super(bankName, cardNumber, holderName, validity, balance);
    }

    public void printCredit(double persent, int creditYear) {
        System.out.println("Процентная ставка по кредиту - " + persent + " процентов" + "Срок кредита - " + creditYear + " лет");
    }


}

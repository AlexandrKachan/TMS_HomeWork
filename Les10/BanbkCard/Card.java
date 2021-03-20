package BanbkCard;

abstract class Card {
    protected static String bankName;
    protected static String cardNumber;
    protected static String holderName;
    protected static String validity;
    protected static double balance;


    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValidity() {
        return validity;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void printInfo() {
        System.out.println("Эмитент карты - " + getBankName() + ". Номер карты - " + getCardNumber() + ". Владелец карты - "
                + getHolderName() + ". Срок действия карты (ММ/ГГ) -  " + getValidity() +
                ". Баланс счета - " + getBalance() + " рублей");

    }


}

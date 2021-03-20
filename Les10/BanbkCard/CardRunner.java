package BanbkCard;

class CardRunner {
    public static void main(String[] args) {


        SalaryCard zp = new SalaryCard();
        zp.setBankName("Белгазпромбанк");
        zp.setCardNumber("1234 5678 9112 3456");
        zp.setHolderName("Качан Александр");
        zp.setValidity("11/30");
        zp.setBalance(10000.01);

        zp.printInfo();
        zp.cardCashback();


        CreditCard cc = new CreditCard("Белгазпромбанк", "1111 2222 3333 4444", "Иванов Иван", "01/77", 777.77);
        cc.printInfo();
        cc.printCredit(22, 3);


        DepositCard dc = new DepositCard();
        dc.setBankName("Roga and Kopyta");
        dc.setCardNumber("1111 1111 1111 1111");
        dc.setHolderName("Joni Dep");
        dc.setValidity("11/90");
        dc.setBalance(1000.01);

        dc.printInfo();
        dc.printDeposit(20, 3);


    }
}

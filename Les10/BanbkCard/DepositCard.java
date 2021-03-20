package BanbkCard;

class DepositCard extends Deposit {


    protected void printDeposit(double persent, int creditYear) {

        System.out.println("Процентная ставка по депозиту - " + persent + " процентов" + "Срок депозита - " + creditYear + " лет");
    }


}

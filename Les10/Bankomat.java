public class Bankomat extends BankomatRuner {
    public int twenty;
    private int fifty;
    private int hundred;
    private int totalMoney;
    private boolean opResult = true;


    //конструктор

    Bankomat(int twenty, int fifty, int hundred) {
        this.twenty = twenty;
        this.fifty = fifty;
        this.hundred = hundred;
        tMoney();

    }

    // метод добавляем деньги
    protected void addMoney(int sumAdd) {
        System.out.println(" Внесите купюру номиналом 20, 50 или 100 долларов");
        if (sumAdd == 20) {
            this.twenty = sumAdd / 20 + twenty;
            System.out.println(" Внесено 20 долларов");
            printResult();

        } else if (sumAdd == 50) {
            this.fifty = sumAdd / 50 + fifty;
            System.out.println(" Внесено 50 долларов");
            printResult();

        } else if (sumAdd == 100) {
            this.hundred = sumAdd / 100 + hundred;
            System.out.println(" Внесено 100 долларов");
            printResult();
        } else {
            System.out.println("Внесена неизвестная купюра");
            opResult = false;
            printResult();
        }
        tMoney();

    }

    // метод снимаем деньги
    protected void removeMoney(int sumRemove) {
        System.out.println("Снимаем " + sumRemove + " долларов");
        //printMoney();
        if (sumRemove > totalMoney) {
            System.out.println("Запрошенная сумма превышает колличество денег в банкомате");
            opResult = false;
            printResult();
        } else {
            int tHandred = sumRemove / 100;
            if (tHandred > this.hundred) {
                tHandred = 0;
            } else {
                sumRemove = (sumRemove % 100);
                this.hundred = hundred - tHandred;
            }
            int tFifty = sumRemove / 50;
            if (tFifty > this.fifty) {
                tFifty = 0;
            } else {
                sumRemove = (sumRemove % 50);
                this.fifty = fifty - tFifty;
            }
            int tTwenty = sumRemove / 20;
            if (tTwenty > this.twenty) {
                tTwenty = 0;
            } else {
                sumRemove = (sumRemove % 20);
                this.twenty=twenty-tTwenty;

            }
                if (sumRemove == 0) {
                System.out.println("Банкомат выдаст " + tHandred + " стодолоровых банкнот, " + tFifty + " пятидесятидолоровах банкнот и " + tTwenty + " двадцатидолларовых банкнот.");
                printResult();
                tMoney();
            } else {
                System.out.println("Невозможно выдать запрошенную сумму имеющимися купюрами");
                opResult = false;
                printResult();
            }
        }

    }


    protected void tMoney() {
        totalMoney = this.twenty * 20 + this.fifty * 50 + this.hundred * 100;
    }

    // метод вывода данных
    public void printMoney() {
        System.out.println("В банкомате " + hundred + " стодолларовых банкнот " + fifty + " пятидесятидолларовых банкнот "
                + twenty + " двадцатидолларовых банкнот" + "   Всего денег в банкомате " + totalMoney);
    }

    public void printResult() {
        if (opResult) {
            System.out.println("*********************Операция выполнена успешно!****************************");
        } else {
            System.out.println("Операция завершилась неудачей, попробуйте еще раз!");
            opResult = true;
        }
    }
}


class BankomatRuner {
    public static void main(String[] args) {
        Bankomat b = new Bankomat(9, 9, 9);

        b.printMoney();

        b.addMoney(20);
        b.addMoney(50);
        b.addMoney(100);
        //b.addMoney(30);

        b.removeMoney(1000);
        b.removeMoney(500);
        b.removeMoney(100);
       // b.removeMoney(100);


        b.printMoney();


    }


}






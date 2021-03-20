public class Exersise21 {
    //Написать 3 цикла выполняющих многократное сложение строк операторами  String, StringBuilder  и StringBuffer
    //Сравните скорость их выполнения.


    public static void main(String[] args) {

//        String str= "Набирай текс руками!!!";
//        StringBuilder first = new StringBuilder();
//        StringBuilder second = new StringBuilder("Набирай руками, кому я сказал!!!");
//        StringBuilder third = new StringBuilder(second);
//        StringBuilder fourth = new StringBuilder(50);
//        StringBuilder builder = new StringBuilder( "Скотина!! ");
//        builder.append(second);
//        System.out.println(builder);
//        StringBuffer;

        String str = "Набирай текс руками, Скацина!!!";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            str += str;
        }
        long endTime = System.currentTimeMillis();
        long Time = endTime - startTime;
        System.out.println("Время выполнения String равно: " + Time + " мс");




        StringBuilder strBild = new StringBuilder("Набирай текс руками, Скацина!!!");
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            strBild.append(strBild);
        }
        long endTime2 = System.currentTimeMillis();
        long Time2 = endTime2 - startTime2;
        System.out.println("Время выполнения StringBuilder равно: " + Time2 + " мс");




        StringBuffer strBaf = new StringBuffer("Набирай текс руками, Скацина!!!");
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            strBaf.append(strBaf);
        }
        long endTime3 = System.currentTimeMillis();
        long Time3 = endTime3 - startTime3;
        System.out.println("Время выполнения StringBuffer равно: " + Time3 + " мс");
    }


}

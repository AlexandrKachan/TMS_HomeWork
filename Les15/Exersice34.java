import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Exersice34 {

    public static void main(String[] args) throws IOException {
//Имеется файл с текстом, в котором присутствуют числа. Найти все числа,
//распечатать, посчитать сумму, убрать все повторяющиеся числа и снова
//распечатать.

        BufferedReader fileInputStream = new BufferedReader(new FileReader("text.txt"));
        String res = fileInputStream.readLine();

        String text2 = "";

        while (res != null) {
            text2 += res;
            res = fileInputStream.readLine();

        }
        fileInputStream.close();
        System.out.println(text2);


        int summ = 0;
        //String str = String.valueOf(text2);
        text2 = text2.replaceAll("(?U)\\D", " ");
       text2 = text2.trim();
        String[] str1 = text2.split(" +");
        System.out.print("Все числа в тексте = ");
        for (int i = 0; i < str1.length; i++) {
            summ += Integer.parseInt(str1[i]);
            System.out.print(str1[i] + " ");
        }
        System.out.println('\n' + "Сумма всех чисел в файле = " + summ);

        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(str1));
        System.out.print("Все числа в тексте без повторений = ");
        for (Object hash : hashSet) {
            System.out.print(hash + " ");
        }





    }
}
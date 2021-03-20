//Написать программу, выполняющую поиск в строке шестнадцатеричных чисел,записаных по правилам Java, с помощью
// регулярных выражений и вывести их на страницу.


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exersice22 {


    public static void main(String[] args) {

        String str = "К примеру,  0x43F 0x440 0x43E 0x432 0x435 0x440 0x43A 0x430 ";

        Pattern p= Pattern.compile("0[Xx][\\da-fA-F]+");
        Matcher m = p.matcher(str);

        while (m.find()){
            System.out.println(m.group());

        }


    }


}












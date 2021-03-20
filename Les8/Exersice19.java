import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exersice19 {


    //Посчитать количество слов в тексте. Желательно учесть, что слова могут разделятся несколькими пробелами,
    // в начале и в конце текста также могут быть пробелы, но могут и отсутствовать.


    public static void main(String[] args) {

        String str = " Посчитать       количество   количество       слов в             тексте.";

        str = str.trim(); // возвращает строку с удаленными начальным и конечным пробелом.
        //str = str.replaceAll(" +", " "); // метод который удаляет пробелы, но мы этого еще не знаем...


        int word = 0;
        char symbol, symbol1;
        int i = 0;

        while (i < str.length()) {
            if (i+1 == str.length()) break; // разорвать цикл, чтоб не выйти за пределы строки

            symbol = str.charAt(i);//Возвращает символ, находящийся в указаной циклом позиции. Разобрали предложение на символы.
            symbol1 = str.charAt(i + 1); // и следующий

            if (symbol == ' ' & symbol1 != ' ') { // если сивол = пробел и следующий символ не равно пробел -> значит слово
                word++;
            }
            i++;
        }
        word++;

        System.out.println(str);
        System.out.println("В тексте  " + word + " слов");
        System.out.println("***************************************************************");


//ВАЖНО!!!! сначало пересматриваем урок, потом делаем домашнее задание. И тогда не понадобится придцмывать велосипед...


        StringTokenizer st = new StringTokenizer(str," ,:");
        List<String> wordList = new ArrayList<>();
        int count = 0;

        while (st.hasMoreTokens()){
            wordList.add(st.nextToken());
            count++;
        }
        wordList.forEach(System.out::println);
        System.out.println(wordList);
        System.out.println("В тексте  " + count + " слов");








    }




}
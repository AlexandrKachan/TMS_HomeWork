public class Exersice20 {

    // Имеется строка с текстом. вывести текст, составленный из последних букв всех слов.


    public static void main(String[] args) {

        String str = "Имеется строка с текстом. вывести текст, составленный из последних букв всех слов";

        str = str.trim(); // возвращает строку с удаленными начальным и конечным пробелом.
        str = str.replaceAll(" +", " "); // метод который удаляет пробелы

        char[] strArray = str.toCharArray(); // превращаем строку в масив
        char[] strArray2 = new char[strArray.length]; //новый масив для последниз букв длинной в первый масив.

        char symbol, symbol1;

        int i = 0, j = 0;

        while (i < str.length()) {
            if (i + 1 == str.length()) break; // разорвать цикл, чтоб не выйти за пределы строки

            symbol = str.charAt(i);//Возвращает символ, находящийся в указаной циклом позиции. Разобрали предложение на символы.
            symbol1 = str.charAt(i + 1); // и следующий

            if (symbol1 == '.' || symbol1 == ',' || symbol1 == ' ') { // если сивол2 = пробел  значит слово
                strArray2[j] = symbol; // заполняем новый масив с последними буквами
                j++;
            }
            i++;
        }


        System.out.println(str);
        System.out.print("Последние буквы слов в тексте: ");


        for (int a = 0; a < strArray2.length; a++) {
            System.out.print(strArray2[a] + "");
        }
        System.out.print(strArray[strArray.length - 1]); // костыль. последняя буква последнего слова


    }

}

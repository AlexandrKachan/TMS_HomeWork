//Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры,
// например <p id=”p1”>, и замену их на простые теги абзацев <p>


public class Exersice23 {
    public static void main(String[] args) {

        String str = "Внимание! Будьте бдительны и осторожны! Во всех подобных статьях (моя не исключение) и сборниках \n" +
                "могут прятаться ошибки. Помните, что лучшие источники знаний — это исходный код и документация.<p>\n" +
                "<p id=”p1”>\n" +
                "Кроме того, зазубривание ответов на вопросы выше не даёт гарантий успешного трудоустройства, \n" +
                "хорошой работы и шелковистости волос.<p id=”p1>\n ";

        System.out.println(str);
        str = str.replaceAll("<((p(\\s(id)?\\s?=\\s?\\W\\S+\\W)?)|(p.+?))>", "<p>");
        System.out.println(str);


    }






}

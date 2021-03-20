//Задание №24. Создать класс и объекты описывающие промежуток времени. Сам промежуток в классе должен
//задаваться тремя свойствами: секундами, минутами, часами. Сделать методы для получения полного количества секунд в
//объекте, сравнения двух объектов (метод должен работать аналогично compareTo в строках). Создать два конструктора:
//получающий общее количество секунд, и часы, минуты и секунды по отдельности. Сделать метод для вывода данных.



public class Time {
    int  min, hour, vsegoSec, h, m, s;

    //Конструктор часы минуты и секунды по отдельности
    Time(int vsegoSec) {
        this.vsegoSec = vsegoSec;
        s = vsegoSec % 60;
        min = (vsegoSec - s) / 60;
        m = min % 60;
        hour = (min - m) / 60;
    }

    //Конструктор общее количество секунд
    Time(int hour, int min, int sec) {
        s = sec;
        sec = s % 60;
        m = (s - sec) / 60 + min;
        h = hour;
        hour = (m - min) / 60 + h;

        this.hour = hour;
        this.m = min;
        this.s = sec;
        this.vsegoSec = hour * 3600 + min * 60 + sec;
    }

    // метод получения общекго количества секунд
    public int sekund() {
        return vsegoSec;
    }
    //метод сравнения двух объектов
    public void compareTime(Time sravnenie) {
        if (vsegoSec == sravnenie.vsegoSec) {
            System.out.println("Интервалы времени равны!");
        } else {
            System.out.println("Интервалы времени не равны!");
        }
    }

    // метод вывода данных
    public void printTime() {
        System.out.println("Всего секунд " + sekund());
        System.out.println("Второй интервал " + hour + " часов " + m + " минут " + s + " секунд");
    }

}

class TimeRuner {
    public static void main(String[] args) {
        Time time1 = new Time(3680);
        Time time2 = new Time(1, 1, 20);


        time1.printTime();
        time2.printTime();
        time2.compareTime(time1);
    }


}
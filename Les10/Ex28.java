public class Ex28 {
//    Написать класс, который умеет хранить в себе массив любых типов данных
//    Реализовать метод get(int index), который возвращает
//    любой элемент массива по индексу.


}


class Array<T> {

    T[] masiv;


    public T[] getMasiv() {
        return masiv;
    }

    public void setMasiv(T... masiv) { //способ Java для передачи varargs (аргументы с переменным числом)
        this.masiv = masiv;
    }

    public T get(int index) {
        return masiv[index];
    }


}


class ArrayRunner extends Array {
    public static void main(String[] args) {

        Array<Object> arr = new Array<>();
        arr.setMasiv(1, 10, 10000, 10.321, 999999999, "123456789", -999, "Test", true);

        System.out.println(arr.get(5));
        System.out.println(arr.get(4));
        System.out.println(arr.get(8));


    }
}

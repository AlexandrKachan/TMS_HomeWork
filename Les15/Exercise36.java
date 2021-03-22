import java.io.File;
//вывести список файлов и каталогов отдельно

public class Exercise36 {
    public static void main(String[] args) {

        File[] files = new File("c:/TMS").listFiles();


        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                System.out.println("Dir - " + files[i].getPath());
            } else {
                System.out.println(" Files - " + files[i].getName());
            }
        }
    }
//        for (File tipe : files) {
//            if (tipe.isDirectory()) {
//                System.out.println("Dir: " + tipe);
//                tipe.listFiles();
//            } else {
//                System.out.println("File: " + tipe);
//
//            }
//        }
//    }
}
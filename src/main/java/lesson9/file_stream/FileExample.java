package lesson9.file_stream;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File fileTest = new File("C:\\Users\\Amber\\Desktop\\additional\\file\\text.txt");
        System.out.println("Size of file: " + fileTest.length());
        System.out.println("Name of the file: " + fileTest.getName());
        System.out.println("Can I write to this file? " + fileTest.canWrite());
        System.out.println("Can I read from this file: " + fileTest.canRead());
        System.out.println("Is it a file? " + fileTest.isFile());
        System.out.println("Is it a directory? " + fileTest.isDirectory());
        System.out.println("=====================");

        File fileFolder = new File("C:\\Users\\Amber\\Desktop\\additional\\file\\");
        System.out.println("Is it a file? " + fileFolder.isFile());
        System.out.println("Is it a directory? " + fileFolder.isDirectory());
        File[] listOfFiles = fileFolder.listFiles();
        int counter = 1;
        for (File file: listOfFiles){
            System.out.println(counter + ") " + file.getName());
            counter++;
        }


    }
}

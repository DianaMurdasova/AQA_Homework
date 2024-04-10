package lesson9.file_stream;

import java.io.*;

public class BufferWriteAndReadFromFile {
    public static void main(String[] args) {
        //write
        try(OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("C:\\Users\\Amber\\Desktop\\additional\\file\\text2.txt")
        )){
            outputStream.write("Text to add".getBytes());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //read
        StringBuilder resultText = new StringBuilder();
        try(InputStream inputStream = new BufferedInputStream(
                new FileInputStream("C:\\Users\\Amber\\Desktop\\additional\\file\\text2.txt")
        )){
            int x;
            while((x = inputStream.read()) != -1){
                resultText.append((char) x);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(resultText);
    }
}

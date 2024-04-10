package lesson9.file_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteInputOutputStreamExample {

    public static void main(String[] args) {
        //InputStream для чтения стрима
        byte[] array = {12, 44, -57}; //-127 till 128; 0 till 255
        // отрицательне числа в массиве превратятся в абсолютное значение 0 - 255
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array);
        int x;
        while ((x = byteStream.read()) != -1){
            System.out.print(x + " ");
        }
        System.out.println("\n================");

        //OutputStream для записи в стрим
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        byteOutput.write(23);
        byteOutput.write(199);
        byteOutput.write(2);
        byte[] arrayFromOutput = byteOutput.toByteArray();
        System.out.println(Arrays.toString(arrayFromOutput));

    }
}

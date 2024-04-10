package lesson9.serialize;

import java.io.*;
import java.util.Arrays;

public class MainSerializeClassPerson {
    public static void main(String[] args) {
        //serialization
        byte[] bytePerson = null;
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            Person person = new Person(32, "Maxim");
            System.out.println(person);
            outputStream.writeObject(person);
            bytePerson = byteArrayOutputStream.toByteArray();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("after serialization: " + Arrays.toString(bytePerson));

        //deserialization
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytePerson);
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)) {
            Person personFromByteArray = (Person) inputStream.readObject();
            System.out.println("Restored person after deserialization: " + personFromByteArray);
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

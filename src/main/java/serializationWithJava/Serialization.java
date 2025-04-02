package serializationWithJava;

import java.io.*;


public class Serialization {
    public static void main(String[] args) {
        serializationMethod();
        deSerializationMethod();
    }

    private static void serializationMethod() {
        try {
            // Serialization
            SerializationEntity serialization = new SerializationEntity();
            FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            serialization.setName("johny");
            objectOutputStream.writeObject(serialization);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Serialization done!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void deSerializationMethod() {
        try {
            // Deserialization
            FileInputStream fileInputStream = new FileInputStream("serialization.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SerializationEntity deserializedObject = (SerializationEntity) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Deserialization done! Name: " + deserializedObject.getName());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

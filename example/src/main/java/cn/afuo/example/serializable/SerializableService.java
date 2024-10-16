package cn.afuo.example.serializable;


import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;

@Service
public class SerializableService {

    private final static String filePath = "/Users/tianci/IdeaProjects/demo/example/src/main/resources/file/serializable.txt";

    public void serializable(SerializableEntity serializable) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(new File(filePath).toPath()));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    public SerializableEntity deserializable() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(new File(filePath).toPath()));
        return (SerializableEntity) objectInputStream.readObject();
    }

}

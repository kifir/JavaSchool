package stepik.task_5_4_8;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Task_5_4_8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Сериализуем класс
        Animal bee = new Animal("Bee");
        Animal bear = new Animal("Bear");

        ArrayList<Animal> animals = new ArrayList();
        animals.add(bee);
        animals.add(bear);

//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Java\\JavaSchool\\src\\stepik\\task_5_4_8\\save.ser");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeInt(animals.size());
        for (Animal animal : animals) {
            objectOutputStream.writeObject(animal);
        }
        objectOutputStream.flush();
        objectOutputStream.close();

        Animal[] deserializeAnimals = deserializeAnimalArray(byteArrayOutputStream .toByteArray());
        if (deserializeAnimals != null && deserializeAnimals.length > 0) {
            for (Animal animal : deserializeAnimals)
                System.out.println(animal.getName());
        } else {
            System.out.println("Результирующий массив пуст");
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data)  {
        InputStream stream = new ByteArrayInputStream(data);
        ObjectInputStream objectStream = null;
        try {
            objectStream = new ObjectInputStream(stream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        int countAnimal = 0;
        try {
            countAnimal = objectStream.readInt();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        Animal[] animals = new Animal[countAnimal];
        for (int i = 0; i < countAnimal; i++){
            try {
                animals[i] = (Animal) objectStream.readObject();
            } catch (IOException | ClassNotFoundException | ClassCastException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return animals;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
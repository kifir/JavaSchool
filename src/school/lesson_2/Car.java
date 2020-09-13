package school.lesson_2;

public class Car {
    private String brand;
    private String body;

    Car(String brand, String body) {
        this.brand = brand;
        this.body = body;
    }
    public String getBody() {
        return body;
    }

    public String getBrand() {
        return brand;
    }
}

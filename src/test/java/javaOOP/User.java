package javaOOP;

public class User {
    public static void main(String[] args) {
        // Khoi tao tu ben ngoai
        // Object/ Instance la doi tuong dai dien cho class
        Car car = new Car();
        car.setFullName();
        car.fullName = "Honda Blade";

        Car secondCar = new Car();

        // khong the khoi tao abstract class
        // Animal animal = new Animal();

        Computer computer = new Computer();
        computer.setRAM();

        // Persion
        Person firstEmp = new Person("Le Tien Dat", "26", "43 Hoa Binh");
        Person secondEmp = new Person("Nguyen Tien Dung", "40", "123 Tan Thang");
    }
}

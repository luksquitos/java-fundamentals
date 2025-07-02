import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car gol = new Car("GOL");
        gol.gas();
    }
}

class Car {
    private String model;

    Car(String model){
        this.model = model;
    }

    public void gas(){
        System.out.println(model);
    }
}
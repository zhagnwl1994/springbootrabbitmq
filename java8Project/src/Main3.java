import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {

        Car car = Car.create(Car::new);


        final List<Car> cars = Arrays.asList(car);


        cars.forEach(Car::collide);

    }
}

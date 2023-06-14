package service;

import model.Car;

import java.util.List;

public class CarService {
    public List<Car> getCarsByCount(List<Car> cars, int count) {
        return cars.stream().limit(count).toList();
    }
}

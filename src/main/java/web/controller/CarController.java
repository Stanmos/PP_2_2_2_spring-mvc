package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarService carService = new CarService();

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, HttpServletRequest request) {
        Car car1 = new Car("Oka", 5, "yellow");
        Car car2 = new Car("Kamaz", 10, "red");
        Car car3 = new Car("Ferrari", 350, "grey");
        Car car4 = new Car("Maybach", 115, "white");
        Car car5 = new Car("Hawal", 444, "black");
        List<Car> cars = new ArrayList<>(List.of(car1, car2, car3, car4, car5));

        String countStr = request.getParameter("count");
        if (countStr == null) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", carService.getCarsByCount(cars, Integer.parseInt(countStr)));
        }

        return "cars";
    }
}

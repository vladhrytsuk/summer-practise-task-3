package com.car.controlles.page.cars;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Car;
import com.car.service.exception.EntityNotFound;
import com.car.service.interfaces.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController
{
    @Autowired
    private CarService carService;

    @Autowired
    private FactoryDTO factoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @ResponseBody
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView List()
    {
        logger.debug("LIST controller");
        return new ModelAndView("user/addCar");
    }

    @ResponseBody
    @RequestMapping(value = "/showlist", method = RequestMethod.GET, produces = "application/json")
    public List<Car> Show()
    {
        logger.debug("SHOW all controller");
        return factoryDTO.CarOutListDTO(carService.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/cars/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car saveCar(@RequestBody @Valid Car car)
    {
        logger.debug("ADD controller");
        return carService.addCar(car);
    }

    @ResponseBody
    @RequestMapping(value = "/cars/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car deleteCar(@RequestBody String carId)
    {
        Long id = Long.valueOf(carId);
        logger.debug("DELETE controller");
        return carService.deleteCar(id);
    }

    @ResponseBody
    @RequestMapping(value = "/cars/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car editCar(@RequestBody @Valid Car car)
    {
        logger.debug("EDIT controller");
        return carService.updateCar(car);
    }

    @ResponseBody
    @RequestMapping(value = "/getCar?userId={userId}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<Car> getCar(@PathVariable ("userId") String userId)
    {
        logger.debug("EDIT controller");
        return carService.getCarUser(Long.valueOf(userId));
    }

}

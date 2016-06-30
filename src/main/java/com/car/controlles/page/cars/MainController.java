package com.car.controlles.page.cars;

import com.car.dto.factory.interfaces.FactoryDTO;
import com.car.entity.Car;
import com.car.entity.Users;
import com.car.service.interfaces.CarService;
import com.car.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController
{
    @Autowired
    private CarService carService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private FactoryDTO factoryDTO;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String MainIndex()
    {
        logger.debug("INDEX controller");
        return "index";
    }

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
        Users users = usersService.getAllUsers().get(0);
        logger.debug("ADD controller");
        return carService.addCar(car, users);
    }

    @ResponseBody
    @RequestMapping(value = "/cars/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car deleteCar(@RequestBody Long carId)
    {
        logger.debug("DELETE controller");
        return carService.deleteCar(carId);
    }

    @ResponseBody
    @RequestMapping(value = "/cars/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car editCar(@RequestBody @Valid Car car)
    {
        logger.debug("EDIT controller");
        return carService.updateCar(car);
    }

}

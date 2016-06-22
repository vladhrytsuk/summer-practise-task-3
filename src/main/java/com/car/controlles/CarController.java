package com.car.controlles;

import com.car.dto.CarDTO;
import com.car.entity.Car;
import com.car.service.interfaces.CarService;
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
public class CarController
{
    @Autowired
    private CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String MainIndex()
    {
        logger.debug("INDEX controller");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView List()
    {
        logger.debug("LIST controller");
        return new ModelAndView("list");
    }

    @ResponseBody
    @RequestMapping(value = "/showlist", method = RequestMethod.GET, produces = "application/json")
    public List<Car> Show()
    {
        logger.debug("SHOW all controller");
        return carService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/list/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car saveCar(@RequestBody @Valid CarDTO carDTO)
    {
        logger.debug("ADD controller");
        return carService.saveCar(carDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/list/delete", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car deleteCar(@RequestBody Long id)
    {
        logger.debug("DELETE controller");
        return carService.deleteCar(id);
    }

    @ResponseBody
    @RequestMapping(value = "/list/edit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Car editCar(@RequestBody @Valid Car car)
    {
        logger.debug("EDIT controller");
        return carService.updateCar(car);
    }

}

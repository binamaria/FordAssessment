package com.ford.project.controller;

import com.ford.project.model.Vehicle;
import com.ford.project.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@Slf4j
@RestController
public class VehicleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VehicleService vehicleService;

    // 1
    @RequestMapping(value = "vehicleInfomation/submitVehicle", method = RequestMethod.POST)
    private ResponseEntity<String> persistVehicle (@RequestBody Vehicle vehicle){

        if(null != vehicle){
            this.vehicleService.save(vehicle);
            logger.info("Persisted Vehicle: " + vehicle.toString());
            return new ResponseEntity<>("Ids Submitted to database successfully", HttpStatus.OK);
        }
            logger.error("Unable to Persist Vehicle: " + vehicle.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 2
    @RequestMapping(value = "/getVehicleInfomation", method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles(){
        logger.info("Getting All Vehicles");
        return this.vehicleService.findAll();
    }

    // 3
    @RequestMapping(value = "/getVehicleModelName/{modelName}", method = RequestMethod.GET)
    private List<Vehicle> getVehicleByModelName(@PathVariable String modelName){
        logger.info("Getting All Vehicles By Model: " + modelName);
        return vehicleService.findVehicleByModel(modelName);
    }

    // 4
    @RequestMapping(value = "/getVehiclePrice/{from}/{to}", method = RequestMethod.GET)
    private List<Vehicle> getVehicleByPrice(@PathVariable BigDecimal from,  @PathVariable BigDecimal to){
        logger.info("Getting All Vehicles From Price: $" + from + " To Price $" + to);
        return vehicleService.findVehiclesByPrice(from, to);
    }
}
